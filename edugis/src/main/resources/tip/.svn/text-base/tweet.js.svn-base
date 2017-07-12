var sys = require("util"),
    http = require("http"),
    url = require("url"),
    path = require("path"),
    fs = require("fs"),
    events = require("events");


var twitterClient = http.createClient(80, 'api.twitter.com');


function getTweets() {
	var request = twitterClient.request("GET", "/1/statuses/public_timeline.json", {"host": "api.twitter.com"});
	
	request.addListener("response", function (response) {
		var body = "";
		// console.log(response.headers);
		
		response.addListener("data", function (data) {
			body += data;
		});

		response.addListener("end", function (end) {
			var tweets = JSON.parse(body);
			if (tweets.length > 0) {
				for ( var i = 0 ; i < tweets.length ; i++) {
					if( tweets[i].user.lang == 'ko'){
						console.log("========================= %d \n", i);
						console.log(tweets[i].user.lang);
						console.log(tweets[i].text);
					}
					// console.log("========================= %d \n", i);
				}
			}
		});
	});

	request.end();
}

setInterval(getTweets, 2000);
