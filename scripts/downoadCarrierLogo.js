process.env.NODE_TLS_REJECT_UNAUTHORIZED = '0';
var https = require('follow-redirects').https;
//var request = require('request');
var async = require('async');
var fs = require('fs');
var airlines = JSON.parse(fs.readFileSync('active_airlines.js', 'utf8'));
var baseUrl = "/assets/carriers/signet/flight";
var baseLocation = "./assets/carriers";
var options = {
  hostname: 'waymate.de',
  port: 443,
  path: '',
  method: 'GET'
};

async.eachSeries(airlines, function(airline, callback) {
  var url = baseUrl.concat("/").concat(airline.iata.toLowerCase()).concat(".svg");
  var file;
  options.path = url;

  setTimeout(function() {
    console.log(airline.name);
    console.log(options.hostname + url);
    //request(url).pipe(fs.createWriteStream(file));
    var req = https.request(options, function(res) {
      res.on('data', function(d) {
        if (res.statusCode == 200) {
          console.log("statusCode: ", res.statusCode);
          file = fs.createWriteStream(baseLocation.concat("/").concat(airline.iata.toLowerCase()).concat(".svg"));
          file.write(d);
        }
      });
    });

    req.end();
    req.on('error', function(e) {
      console.error(e);
    });

    callback();
  }, 2000);

}, function(err) {
  console.log('iterating done');
});
