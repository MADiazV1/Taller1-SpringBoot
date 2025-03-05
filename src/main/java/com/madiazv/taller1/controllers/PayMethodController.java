package com.madiazv.taller1.controllers;

import com.madiazv.taller1.models.PayMethod;
import com.madiazv.taller1.repositories.PayMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PayMethodController {
    @Autowired
    private PayMethodRepository payMethodRepository;

    @GetMapping("/methodsOfPayment")
    public String listPayMethods(Model model) {
        List<PayMethod> payMethods = payMethodRepository.findAll();

        model.addAttribute("title", "Sitio Web");
        model.addAttribute("subtitle", "Methods of Payment");
        model.addAttribute("payMethods", payMethods);

        return "payMethod/showList";
    }

    @GetMapping("/methodsOfPayment/{id}")
    public String payMethod(@PathVariable("id") Long id, Model model) {
        PayMethod payMethod = payMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encuenta metodo de pago"));

        model.addAttribute("title", "Sitio Web");
        model.addAttribute("subtitle", "Tarjeta");
        model.addAttribute("payMethod", payMethod);

        return "payMethod/show";
    }

    @GetMapping("/addMethodsOfPayment")
    public String createMethodOfPaymentFrom(Model model) {
        model.addAttribute("payMethod", new PayMethod());

        return "payMethod/createPayMethod";
    }

    @PostMapping("/methodsOfPayment")
    public String save(PayMethod payMethod) {
        if (payMethod.getMonth() == null || payMethod.getYear() == null) {
            throw new RuntimeException("Mes y año de expiración son requeridos");
        }

        payMethod.setExpirationDate(payMethod.getMonth() + "/" + payMethod.getYear());

        if (payMethod.getOwnersName().isEmpty()){
            throw new RuntimeException("Nombre del titular es requerido");
        } else if (payMethod.getCardNumber().isEmpty()) {
            throw new RuntimeException("Número de la tarjeta es requerido");
        } else if (payMethod.getCvv().isEmpty()) {
            throw new RuntimeException("CVV es requerido");
        } else if (payMethod.getExpirationDate().isEmpty()) {
            throw new RuntimeException("Fecha de expiración es requerida");
        }

        payMethodRepository.save(payMethod);

        return "redirect:/methodsOfPayment";
    }

    // ------------------------------------------------------------------------

    @PostMapping("/methodsOfPayment/delete/{id}")
    public String deletePayMethod(@PathVariable Long id) {
        if (!payMethodRepository.existsById(id)) {
            throw new RuntimeException("Método de pago no encontrado");
        }

        payMethodRepository.deleteById(id);
        return "redirect:/methodsOfPayment"; // Redirige a la lista de métodos de pago
    }

}
