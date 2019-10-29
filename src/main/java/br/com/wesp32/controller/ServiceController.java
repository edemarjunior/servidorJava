package br.com.wesp32.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.server.mvc.Viewable;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import br.com.wesp32.entity.AlunoEntity;
import br.com.wesp32.entity.PresencaEntity;
import br.com.wesp32.entity.RawEntity;
import br.com.wesp32.http.Presenca;
import br.com.wesp32.repository.ConnectionRepository;
import javax.ws.rs.core.Response;

@Path("/service")
@Controller
public class ServiceController {
	private final ConnectionRepository repository = new ConnectionRepository();

	@POST
	@Produces("application/json; charset=UTF-8")
	@Path("/getAut")

	public String getPessoa() {
		Auth0 auth = new Auth0();
		String menssagem = auth.generateToken();

		return menssagem;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/verAut/{token}")

	public String getTese(@PathParam("token") String codigo) {
		Auth0 auth = new Auth0();
		String menssagem = auth.verificToken(codigo);

		return menssagem;
	}

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/getAluno")
	public String GetAluno(String json) {
		String senha = "";
		String usuario = "";
		try {
			json.replaceAll("\n", "");
			JSONObject infoLogin = new JSONObject(json.trim());
			senha = infoLogin.getString("senha");
			usuario = infoLogin.getString("usuario");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		List<AlunoEntity> aluno = repository.getLogin(usuario, senha);

		if (aluno.size() > 0) {
			Auth0 auth = new Auth0();
			String token = auth.generateToken();
			return token;

		}

		return "";
	}

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/getRaw")
	public String getRaw(String json) {
		String esp = "", sala = "";
		int tipo = 0;
		try {
			json.replaceAll("\n", "");
			JSONObject info = new JSONObject(json.trim());
			esp = info.getString("esp");
			sala = info.getString("sala");
			tipo = info.getInt("tipo");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		List<RawEntity> rawEntity = repository.getRaw(sala, esp, tipo);

		if (rawEntity.size() > 0)
			return rawEntity.get(0).getRaw_inf();
		else
			return "";
	}

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/insertRaw")
	public String insertRaw(String json) {
		String esp = "", sala = "", raw = "";
		int tipo = 0;
		try {
			json.replaceAll("\n", "");
			JSONObject info = new JSONObject(json.trim());
			esp = info.getString("esp");
			sala = info.getString("sala");
			tipo = info.getInt("tipo");
			raw = info.getString("raw");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		RawEntity rawEntity = new RawEntity();
		rawEntity.setEsp_inf(esp);
		rawEntity.setRaw_inf(raw);
		rawEntity.setSala_inf(sala);
		rawEntity.setTipo_inf(tipo);

		repository.salvarRaw(rawEntity);

		return "OK";
	}

	public String conection(String urlPath, String usuario, String senha, String token) {
		JSONObject jsonObject = null;
		try {
			URL url = new URL(urlPath);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			JSONObject auth = new JSONObject();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Accept", "application/json");
			auth.put("login", usuario + "@furb.br");

			if (token != null && token.length() > 0) {
				con.setRequestProperty("x-access-token", token);
			} else {
				auth.put("password", senha);
			}

			con.setRequestMethod("POST");

			OutputStream os = con.getOutputStream();
			os.write(auth.toString().getBytes("UTF-8"));
			os.close();

			// read the response
			if (con.getResponseCode() == 200) {
				InputStream in = new BufferedInputStream(con.getInputStream());
				String result = IOUtils.toString(in, "UTF-8");
				jsonObject = new JSONObject(result);
				in.close();
			}

			con.disconnect();
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		try {
			if (jsonObject != null) {
				if (token != null && token.length() > 0) {
					if (jsonObject.has("isTeacher") && jsonObject.get("isTeacher").equals("true"))
						return "true";
					else
						return "";
				} else {
					if ((boolean) jsonObject.get("auth"))
						return (String) jsonObject.get("token");
					else
						return "";
				}
			} else
				return "";

		} catch (JSONException e) {
			e.printStackTrace();
			return "";
		}

	}

	@POST
	@Path("/presencas")
	@Produces("text/html; charset=UTF-8")
	public Response listaPage(@FormParam("usu") String _usuario, @FormParam("senha") String _senha,
			@FormParam("dataini") String _dataini, @FormParam("datafim") String _datafim,
			@FormParam("sala") String _sala) throws ParseException {
		String usuario = _usuario;
		String senha = _senha;
		String token = "";
		try {
			token = conection("https://api.furb.br/user/login", usuario, senha, null);
		} catch (Exception e) {
			List<String> presencas = new ArrayList<String>();
			presencas.add("Not");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("items", presencas);
			return Response.ok(new Viewable("/index.jsp", map)).build();
		}

		if (token != null && token.length() > 0
				&& conection("https://api.furb.br/user/isTeacher", usuario, null, token).equals("true")) {
			Date dataini = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(_dataini);
			Date datafim = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(_datafim);
			String sala = _sala;
			List<PresencaEntity> presencas = repository.getPresencas(sala, dataini, datafim);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("items", presencas);
			return Response.ok(new Viewable("/lista.jsp", map)).build();

		} else {
			List<String> presencas = new ArrayList<String>();
			presencas.add("Not");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("items", presencas);
			return Response.ok(new Viewable("/index.jsp", map)).build();

		}
	}

	@POST
	@Path("/listapresencas")
	@Produces("application/json; charset=UTF-8")
	public List<PresencaEntity> getPresencas(@QueryParam("dataini") String _dataini,
			@QueryParam("datafim") String _datafim, @QueryParam("sala") String _sala) throws ParseException {

		Date dataini = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(_dataini);
		Date datafim = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(_datafim);
		String sala = _sala;
		List<PresencaEntity> presencas = repository.getPresencas(sala, dataini, datafim);
		return presencas;
	}

	@GET
	@Path("/pesquisa")
	@Produces("text/html; charset=UTF-8")
	public Response loginPage() {
		return Response.ok(new Viewable("/index.jsp", null)).build();
	}

	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/registraPresenca")
	public String registraPresenca(String json) {
		String aluno, esp32, sala, mac = "";

		try {
			json.replaceAll("\n", "");
			JSONObject j = new JSONObject(json.trim());
			int count = j.length();

			if (count > 0) {

				for (int i = 0; i < count; i++) {
					JSONObject obj = j.getJSONObject("" + i);
					aluno = obj.getString("aluno");
					esp32 = obj.getString("esp");
					sala = obj.getString("sala");
					mac = obj.getString("mac");
					TimeZone.setDefault(TimeZone.getTimeZone("GMT-03:00"));

					if (!aluno.trim().equals("")) {
						registraPresenca(new Presenca(new Date(), aluno, mac, esp32, sala));
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "OK";
	}

	public void registraPresenca(Presenca presenca) {
		try {
			PresencaEntity presencaEntity = new PresencaEntity();
			presencaEntity.setData_pre(new Date());
			presencaEntity.setAluno_pre(presenca.getAluno_pre());
			presencaEntity.setEndmac_pre(presenca.getEndmac_pre());
			presencaEntity.setNmesp_pre(presenca.getNmesp_pre());
			presencaEntity.setSala_pre(presenca.getSala_pre());

			repository.salvarPresenca(presencaEntity);
		} catch (Exception e) {
		}
	}

}
