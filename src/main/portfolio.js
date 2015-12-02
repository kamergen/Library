function ApplicationModel() {
    var self = this;

    self.connect = function () {

        var host = $("#host")[0].value;

        $("#hello").on("click", function (event) {
            event.preventDefault();

            $.ajax({
                type: "GET",
                url: host + "/public/hello",
                dataType: "json",
                success: function (data) {
                    var d = document.createElement("div");
                    $(d).html("<p class='text-primary'>" + data.text + "</p>").appendTo($("#result"));
                }
            });
        });

        $("#ping").on("click", function (event) {
            event.preventDefault();

            var input = $("#token")[0];
            var token = input.value;

            $.ajax({
                type: "GET",
                url: host + "/ping",
                dataType: "json",
                headers: {
                    "Authorization": "Bearer " + token
                },
                success: function (data) {
                    var d = document.createElement("div");
                    $(d).html("<p class='text-primary'>" + data + "</p>").appendTo($("#result"));
                }
            });
        });

        $("#connect").on("click", function (event) {
            event.preventDefault();

            $.ajax({
                type: "POST",
                url: host + "/oauth/token",
                dataType: "json",
                data: {
                    grant_type: "password",
                    client_id: "reaxys",
                    client_secret: "reaxys",
                    password: "Epam2015",
                    username: "Dmitriy_Chirkov@epam.com",
                    ipAddress: "10.66.13.90"
                },
                success: function (data) {
                    var input = $("#token")[0];
                    input.value = data.access_token;
                }
            });
        });

        $("#disconnect").on("click", function (event) {
            event.preventDefault();

            var input = $("#token")[0];
            var token = input.value;

            if (!token) {
                alert('wrong ' + token);
                return;
            }

            $.ajax({
                type: "GET",
                url: host + "/disconnect",
                dataType: "json",
                headers: {
                    "Authorization": "Bearer " + token
                },
                success: function () {
                    input.value = "";
                }
            })
        });

        $("#start").on("click", function (event) {
            event.preventDefault();

            var input = $("#token")[0];
            var token = input.value;

            if (!token) {
                alert('wrong ' + token);
                return;
            }

            //var host = "http://10.66.13.90:8080";
            var url = host + "/ws?access_token=" + token;
            var socket = new SockJS(url);
            var stompClient = Stomp.over(socket);

            self.client = stompClient;

            stompClient.connect({}, function (frame) {

                console.log('Connected ' + frame);

                $("#startStatus").html("WebSocket is started");

                stompClient.subscribe("/user/progress/info", function (message) {

                    var d = document.createElement("div");
                    $(d).html("<p class='text-primary'>" + message.body + "</p>").appendTo($("#result"));

                });

                stompClient.subscribe("/user/search/info", function (message) {

                    var d = document.createElement("div");
                    $(d).html("<p class='text-success'>" + message.body + "</p>").appendTo($("#result"));

                });

                stompClient.subscribe("/user/queue/errors", function (message) {
                    $("#error").html(message.body);
                });
            }, function (error) {
                console.log("STOMP protocol error " + error);
            });

        });
    };


    self.contentOverview =  function () {
        $("#contentOverview").on("click", function (event) {
            event.preventDefault();

            $("#result").html("...content overview...");

            self.client.send("/app/search/contentOverview", {}, JSON.stringify({
                databases: [0]
            }));

            $("#sendStatus").html(" content overview query is started");
        });
    };

    self.startSearch = function () {
        $("#send").on("click", function (event) {
            event.preventDefault();

            var input = $("#content")[0];
            var content = input.value;

            var inputStructure = $("#structure")[0];
            var structure = inputStructure.value;

            if (!content && !structure) {
                console.log('wrong content:' + content + " or structure:" + structure);
                return;
            }

            $("#result").html("...");

            self.client.send("/app/search/quick", {}, JSON.stringify({
                content: content,
                structure: structure,
                databases: [0]
            }));
            input.value = "";

            $("#sendStatus").html("Query is started");
        });
    };

    self.cancelSearch = function () {
        $("#cancel").on("click", function (event) {
            event.preventDefault();
            var input = $("#query")[0];
            var queryId = input.value;
            self.client.send("/app/search/cancel", {}, queryId);
            input.value = "";

            $("#cancelStatus").html("Query is canceled");
        });
    }
}