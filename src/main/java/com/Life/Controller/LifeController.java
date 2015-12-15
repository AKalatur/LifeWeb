package com.Life.Controller;

import com.Life.Round.RoundOfLife;
import com.Life.Start.LifeCycle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/")
public class LifeController {
	private LifeCycle point;
	private boolean start = false;
	private int roundCount = 1;
	private int[][] arr;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		start = false;
		LifeCycle.arrN = 0;
		LifeCycle.arrK = 0;
		roundCount = 1;
		return "index";
	}

	@RequestMapping(value = "redirect", method = RequestMethod.GET)
	public String redirect(@RequestParam("fieldN") int fieldN, @RequestParam("fieldK") int fieldK) {
		LifeCycle.arrN = fieldN;
		LifeCycle.arrK = fieldK;

		return "redirect:round";
	}

	@RequestMapping(value = "round", method = RequestMethod.GET)
	public String printLife(ModelMap model) throws InterruptedException {

		//start of life cycle
		if (!start) {
			point = new LifeCycle(LifeCycle.arrN, LifeCycle.arrK);
			new Thread(point).start();
			Thread.sleep(1000);
			start = true;
		}

		//select rounds from a map (value = roundCount)
		Set<Map.Entry<RoundOfLife, Integer>> set = point.lifeMap.entrySet();
		for (Map.Entry<RoundOfLife, Integer> entry : set) {
			if (entry.getValue() == roundCount)
				arr = entry.getKey().lArray;
		}
		if (roundCount == point.lifeMap.size()) {
			model.addAttribute("message", point.mes);
		}

		if (roundCount < point.lifeMap.size()) roundCount++;

		model.addAttribute("arrL1", LifeCycle.arrN);
		model.addAttribute("arrL2", LifeCycle.arrN);
		model.addAttribute("count", roundCount);
		model.addAttribute("arr", arr);

		return "round";
	}
}

