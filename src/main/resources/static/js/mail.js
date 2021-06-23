function sendEmail() {
    Email.send({
      Host: "smtp.gmail.com",
      Username: "akash.ranjan1999@gmail.com",
      Password: "Github@2020",
      To: 'akash.ranjan1999@gmail.com',
      From: "akash.ranjan1999@gmail.com",
    //   Subject: document.getElementById("subject"),
    //   Body: document.getElementById("message") + "\n\nFrom,\nName: " + document.getElementById("username") + "\nEmail: " + document.getElementById("email") + "\nPhone: " + document.getElementById("contact"),
    Subject: "Query",
    Body: "hello",
    //   Attachments: [
    //     {
    //       name: "File_Name_with_Extension",
    //       path: "Full Path of the file"
    //     }]
    })
      .then(function (message) {
        alert("Mail has been sent successfully")
      });
}