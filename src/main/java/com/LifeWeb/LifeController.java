package com.LifeWeb;

import com.Life.EntryPoint;
import com.Life.RoundOfLife;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/Life")
public class LifeController {
	boolean start = false;
	int[][] arr;
	int roundCount = 1;

	@RequestMapping(method = RequestMethod.GET)
	public String printLife(@RequestParam("fieldN") int fieldN, @RequestParam("fieldK") int fieldK,
							ModelMap model) throws InterruptedException {

		//запуск цикла жизни в отдельном потоке
		if (!start) {
			EntryPoint.n = fieldN;
			EntryPoint.k = fieldK;
			new Thread(new EntryPoint()).start();
			Thread.sleep(1000);
			start = true;
		}

		//перебор всех раундов, отбираем по value(roundCount) из мапы
		Set<Map.Entry<RoundOfLife, Integer>> set = EntryPoint.lifeMap.entrySet();
		for (Map.Entry<RoundOfLife, Integer> entry : set) {
			if (entry.getValue() == roundCount)
				arr = entry.getKey().lArray;
		}
		if (roundCount >= EntryPoint.lifeMap.size() - 1) {
			model.addAttribute("message", EntryPoint.mes);
		}

		if (roundCount < EntryPoint.lifeMap.size()) roundCount++;
		if (roundCount == EntryPoint.lifeMap.size() && EntryPoint.count1 > 0) roundCount--;


		model.addAttribute("fieldN", EntryPoint.n);
		model.addAttribute("fieldK", EntryPoint.k);
		model.addAttribute("count", roundCount);
		model.addAttribute("arr", arr);

		return "round";
	}
}

