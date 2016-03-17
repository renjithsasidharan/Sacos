var fs = require('fs');
var airlines = JSON.parse(fs.readFileSync('airlines.js', 'utf8'));
var activeAilines = [];
airlines.forEach(function(airline, index) {
    if (airline.active === "Y" && airline.iata !== "" && airline.name !== "") {
        activeAilines.push(airline);
    }

    if (index === (airlines.length - 1)) {
        fs.writeFileSync('active_airlines.js', JSON.stringify(activeAilines) , 'utf-8');
        console.log("The file was saved!");
    }
});
