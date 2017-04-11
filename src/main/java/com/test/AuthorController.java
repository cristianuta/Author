package com.test;

import com.test.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.service.AuthorService;

@Controller
public class AuthorController {
	
	private AuthorService authorService;
	
	@Autowired(required=true)
	public void setAuthorService(AuthorService ps){
		this.authorService = ps;
	}
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("author", new Author());
		model.addAttribute("listAuthors", this.authorService.listAuthors());
		return "author";
	}
	
	//For add and update person both
	@RequestMapping(value= "/author/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("author") Author r){
		
		if(r.getId() == 0){
			//new author, add it
			this.authorService.addAuthor(r);
		}else{
			//existing person, call update
			this.authorService.updateAuthor(r);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.authorService.removeAuthor(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.authorService.getAuthorById(id));
        model.addAttribute("listPersons", this.authorService.listAuthors());
        return "author";
    }
	
}
