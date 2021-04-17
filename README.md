# cocktail-mate
App to browse cocktails with their recipes for some weekend (or weekday, no judgement) inspiration.

The back-end was built using Spring Boot with multiple dependencies, one of which was Spring Boot Data JPA to connect to a self-compiled MySQL database.

The front-end began life as a template, which turned out to be a hindrance more than help. It gave me hardly any freedom to create and move things around, so a lot of time was spent diving into the template code to understand why it was behaving in such a stubborn manner. It was eventually adapted to use the Thymeleaf template engine as well as Bootstrap CSS and JavaScript/JQuery functionality.

There are still a few things that need to be updated in the near future, such as:

- Use Thymeleaf layouts to cut down code and make it easier to update.
- It is not yet fully responsive, particularly the Navbar on small screens.
- Pagination of the cocktail list, to speed up loading.
- Add Gzip compression to further decrease loading time.
- Add more cocktails to the database so more 'Helper' questions can be added.
- With more cocktails and queries, a service layer needs to be added. I did not add one in the first place as it is currently very simple to implement in the controller.
- The random cocktail nextInt() function is hardcoded. Need to get rid of that for scalability.
- Add some columns to MySQL database to allow for cleaner and easier MySQL queries in the controller/service. Currently too ugly and convoluted.
- Find an alternative for the mailto: links to ensure it is supported on all browsers.
- Add a 404 page.

Once I start implementing these changes, I will also dive deeper into either React or Angular and rebuild the entire front-end.
