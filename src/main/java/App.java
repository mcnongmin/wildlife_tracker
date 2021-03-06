/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import java.util.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
		staticFileLocation("/public");
    String layout = "templates/layout.vtl";
		
		get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
		
		get("/animals/new",(request,response)->{
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("template", "templates/animal-form.vtl");
			return new ModelAndView(model,layout);
		}, new VelocityTemplateEngine());
		
		get("/protectedAnimals", (request, response)->{
			Map<String, Object> model = new HashMap<String,Object>();
			model.put("protectedAnimals", ProtectedAnimal.allProtected());
			model.put("template","templates/protectedAnimals.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		get("/endangeredAnimals", (request, response)->{
			Map<String, Object> model = new HashMap<String,Object>();
			model.put("endangeredAnimals", EndangeredAnimal.allEndangered());
			model.put("template","templates/endangeredAnimals.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		get("/allAnimals", (request, response)->{
			Map<String, Object> model = new HashMap<String,Object>();
			model.put("sightings", Sighting.all());
			model.put("animals", ProtectedAnimal.all());
			model.put("template","templates/allAnimals.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		get("/sightings/new", (request, response)->{
			Map<String, Object> model = new HashMap<String,Object>();
			model.put("animals", ProtectedAnimal.all());
			model.put("template","templates/sighting-form.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		get("/sightings", (request, response)->{
			Map<String, Object> model = new HashMap<String,Object>();
			model.put("sightings",Sighting.all());
			model.put("animals", ProtectedAnimal.all());
			model.put("template","templates/sightings.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		post("/sightings",(request, response)->{
			Map<String, Object> model = new HashMap<String,Object>();
			String rangerName = request.queryParams("rangerName");
			String location = request.queryParams("location");
			int animalId = Integer.parseInt(request.queryParams("amimalId"));
			Sighting newSighting = new Sighting(location,animalId,rangerName);
			newSighting.save();
			String url = String.format("/sightings");
			response.redirect(url);
			return new ModelAndView(model,layout);
		}, new VelocityTemplateEngine());
		
		post("/protectedAnimals",(request, response)->{
			Map<String, Object> model = new HashMap<String,Object>();
			String name = request.queryParams("name");
			ProtectedAnimal newAnimal = new ProtectedAnimal(name);
			newAnimal.save();
			String url = String.format("/protectedAnimals");
			response.redirect(url);
			return new ModelAndView(model,layout);
		}, new VelocityTemplateEngine());
		
		post("/endangeredAnimals",(request, response)->{
			Map<String, Object> model = new HashMap<String,Object>();
			String name = request.queryParams("name");
			String health = request.queryParams("health");
			String age = request.queryParams("age");
			EndangeredAnimal newAnimal = new EndangeredAnimal(name,health,age);
			newAnimal.save();
			String url = String.format("/endangeredAnimals");
			response.redirect(url);
			return new ModelAndView(model,layout);
		}, new VelocityTemplateEngine());
		
		
		
		
	}
}
