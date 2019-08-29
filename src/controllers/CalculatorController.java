package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private final String ADD = "+";
    private final String SUB = "-";
    private final String MUL = "*";
    private final String DIV = "/";

    @GetMapping("/calculate")
    public String calculate(@RequestParam String number1, @RequestParam String operator, @RequestParam String number2, Model model){
        Float result = null;
        float num1 = Float.parseFloat(number1);
        float num2 = Float.parseFloat(number2);
        switch (operator){
            case ADD:{
                result = num1+num2;
                break;
            }
            case SUB:{
                result = num1-num2;
                break;
            }
            case MUL:{
                result = num1 * num2;
                break;
            }
            case DIV:{
                if (num2 != 0){
                    result = num1 / num2;
                }
                break;
            }
        }
        if (result != null){
            model.addAttribute("number1", number1);
            model.addAttribute("operator", operator);
            model.addAttribute("number2", number2);
            model.addAttribute("result", result);
        } else {
            model.addAttribute("number1", number1);
            model.addAttribute("operator", operator);
            model.addAttribute("number2", number2);
            model.addAttribute("result", "Division By Zero");
        }
        return "index";
    }
}
