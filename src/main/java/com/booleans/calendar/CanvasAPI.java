
/*
String canvasBaseUrl = "https://<institution>.instructure.com";
OauthToken oauthToken = new NonRefreshableOauthToken("mYSecreTtoKen932781");
CanvasApiFactory apiFactory = new CanvasApiFactory(canvasBaseUrl);
AccountReader acctReader = apiFactory.getReader(AccountReader.class, oauthToken);
Account rootAccount = acctReader.getSingleAccount("1").get();

GetUsersInCourseOptions options =
    new GetUsersInCourseOptions("1234") //required course ID
    .searchTerm("John")
    .enrollmentType(Arrays.asList(EnrollmentType.STUDENT, EnrollmentType.OBSERVER));
List<User> users = userReader.getUsersInCourse(options);

GetUsersInCourseOptions options = new GetUsersInCourseOptions("1146");
List<User> courseUsers = userReader.withCallback(this::processUserPage).getUsersInCourse(options);
System.out.println("Total users in course: " + courseUsers.size());

private void processUserPage(List<User> users) {
    System.out.println("Got a page of users back: " + users.size());
}
*/
