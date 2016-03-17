var http = require('http');
var fs = require('fs');

var baseUrl = "https://www.waymate.de/assets/carriers/signet/flight";
var airlines = JSON.parse(fs.readFileSync('file', 'utf8'));

var file = fs.createWriteStream("file.jpg");
var request = http.get("http://i3.ytimg.com/vi/J---aiyznGQ/mqdefault.jpg", function(response) {
  response.pipe(file);
});