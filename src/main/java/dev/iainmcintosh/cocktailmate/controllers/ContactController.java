package dev.iainmcintosh.cocktailmate.controllers;

import dev.iainmcintosh.cocktailmate.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
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
@EnableAsync
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

    @Async
    @PostMapping
    public String sendForm(@ModelAttribute("contact") Contact contact, Model model) throws MessagingException
    {
        String content = "You have a new message on CocktailMate. Sent from: " + contact.getName();
        content += "<br><br>Email address: " + contact.getEmail();
        content += "<br><br>Message:<br>" + contact.getMessage();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo("iaindev86@gmail.com");
        mimeMessageHelper.setSubject(contact.getSubject());
        mimeMessageHelper.setText(content, true);
        mimeMessageHelper.setSentDate(new Date());
        javaMailSender.send(mimeMessage);

        return "redirect:/home";
    }
}
