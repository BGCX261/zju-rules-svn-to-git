package com.zju.webapp.controller.rule;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zju.model.Bag;
import com.zju.model.IDMap;
import com.zju.service.BagManager;

@Controller
@RequestMapping("/rule/list*")
public class RuleListController {

	private BagManager bag = null;

    @Autowired
    public void setBag(BagManager bag) {
		this.bag = bag;
	}
    
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		if (bag.getBags().size() != 0) {
			System.out.println(bag.getBags().get(0).getName());
		} else {
			System.out.println(bag.getBags().size());
		}
		Bag _bag = bag.getBags().get(0);
		Set<IDMap> set = _bag.getIdMap();
		
		for(IDMap m : set) {
			System.out.println(m.getHospital());
		}
		
		System.out.println("OK~~~~~123~~~~~~~~~~~~~~~~~~~~");
		return new ModelAndView("rule/ruleList");
	}

}
