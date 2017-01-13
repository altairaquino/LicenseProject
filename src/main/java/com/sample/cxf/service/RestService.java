package com.sample.cxf.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sample.cxf.dto.ForecastResponse;
import com.sample.cxf.dto.JsonResponse;

@CrossOriginResourceSharing(
        allowOrigins = {"*"},
        allowAllOrigins = true
)

@Service
@Path("/" + RestService.VERSION_NAME)
public class RestService {
	
	public static final String VERSION_NAME = "v1";
	
	@Value("${app.access.key}")
	private String keyAcess;
	
	@GET
	@Path("/test/{name}{format:(/format/[^/]+?)?}{encoding:(/encoding/[^/]+?)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(@PathParam("name") String name) {
		List<JsonResponse> list = new ArrayList<JsonResponse>();
		try {
			list.add(new JsonResponse(name));
			return Response.ok(list).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/test2{name:(/name/[^/]+?)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test2(@PathParam("name") String name) {
		List<JsonResponse> list = new ArrayList<JsonResponse>();
		try {
			if (name == null){
				list.add(new JsonResponse("vazio"));
			}else{				
				list.add(new JsonResponse(name));
			}
			return Response.ok(list).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/forecasts/{painelId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response forecasts(@PathParam("painelId") Integer painelId, @Context HttpHeaders headers) {
		try {
			
			if (!isValidKeyAccess(headers)){
				return Response.status(Status.METHOD_NOT_ALLOWED).build();
			}
			
			List<ForecastResponse> list = new ArrayList<ForecastResponse>();
			
			ForecastResponse forecastResponse = new ForecastResponse();
			forecastResponse.setCampo1("a1");
			forecastResponse.setCampo2("a2");
			forecastResponse.setCampo3("a3");
			
			list.add(forecastResponse);
			
			return Response.status(Status.OK).entity(list).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/painelInfo/{painelId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response painelInfo(@PathParam("painelId") Integer painelId, @Context HttpHeaders headers) {
		try {
			
			if (!isValidKeyAccess(headers)){
				return Response.status(Status.METHOD_NOT_ALLOWED).build();
			}
			
			List<ForecastResponse> list = new ArrayList<ForecastResponse>();
			
			ForecastResponse forecastResponse = new ForecastResponse();
			forecastResponse.setCampo1("a1");
			forecastResponse.setCampo2("a2");
			forecastResponse.setCampo3("a3");
			
			list.add(forecastResponse);
			
			return Response.status(Status.OK).entity(list).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	private Boolean isValidKeyAccess(HttpHeaders headers){
		String keyAcess = headers.getRequestHeaders().getFirst("keyAcess");
		
		if (this.keyAcess.equals(keyAcess)){
			return true;
		}
		return false;
	}
	
	

}