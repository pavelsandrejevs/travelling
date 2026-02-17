package pavelsandrejevs.travelling;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import pavelsandrejevs.travelling.Order;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    @GetMapping("/current")
    public String showOrderForm() {
        return "orderForm";
    }
    
    @PostMapping
    public String processOrder(Order order,
            SessionStatus sessionStatus) {
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        //return "redirect:/home.html";
        //return "redirect:/";
        return "home";
    }
    
/* 
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors,
            SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
*/
}
