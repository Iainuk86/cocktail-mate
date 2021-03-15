package org.iainuk.cocktailapp.controllers;

import org.iainuk.cocktailapp.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping
    public String showContactForm(Model model)
    {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping
    public String sendForm(@ModelAttribute("contact") Contact contact, Model model) throws MessagingException
    {
        String content = contact.getMessage();
        content += "<br><br>Sent from: " + contact.getName();
        content += "<br><br>Email me back on: " + contact.getEmail();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo("iaindev86@gmail.com");
        mimeMessageHelper.setSubject(contact.getSubject());
        mimeMessageHelper.setText(content, true);
        mimeMessageHelper.setSentDate(new Date());
        javaMailSender.send(mimeMessage);

        return "home";
    }
}
