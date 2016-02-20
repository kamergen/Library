var user;
var file;
var role = $.cookie("role");
$(document).ready(function() {
	if (role && role == 'ROLE_ADMIN') {
		if ($.cookie("userInfoid")) {
			getAllUsers();
			getAllBooks();
			getUser($.cookie("userInfoid"));
		}
	} else if (role && role == "ROLE_USER") {
		if ($.cookie("userInfoid")) {
			getAllBooks();
			getbooksUser($.cookie("userInfoid"));
			getUser($.cookie("userInfoid"));
		}
	}
	if ($.cookie("userInfo") == "NaN")
		$.cookie("userInfo", "null")
	if ($.cookie("userInfo") == "null" || $.cookie("userInfo") == null) {
		$('.nav li').hide()
		$('#registr').show();
		$('#login').show();
		window.location.href = "#login";
	} else if ($.cookie("userInfo") != "null") {
		if (role == "ROLE_ADMIN") {
			$(".user").hide();
		} else if (role == "ROLE_USER") {
			$(".librarian").hide();
		}
		$('#registr').hide();
		$('#login').hide();
	}
});
function listBooks() {
	var url = "http://localhost:8080/books/all";
	var request = $.ajax
	  ({
		    type: "GET",
		    url: url,
		    dataType: 'json',
		    async: false,
		    beforeSend: function (xhr) {
		        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
		    },
		});
	request.done(function(dataBooks) {
		if (dataBooks.length > 0) {
			$('.listBooks').append('<select size="5"  class="listBooksItem">');
			$.each(dataBooks, function view(i) {
				$('.listBooksItem').append(
						'<option value=' + dataBooks[i].id + '>'+ dataBooks[i].title + '</option>');
			})
			$('.listBooks').append('</select>');
		} else {
			$('.listBooks').empty();
		}
	});
}
function listUsers() {
	var url = "http://localhost:8080/users/all";
	var request =$.ajax
	  ({
		    type: "GET",
		    url: url,
		    dataType: 'json',
		    async: false,
		    beforeSend: function (xhr) {
		        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
		    },
		});
	request.done(function(dataUsers) {
		if (dataUsers.length > 0) {
			$('.listUsers').append('<select size="5"  class="listUsersItem">');
			$.each(dataUsers, function view(i) {
				$('.listUsersItem').append(
						'<option value=' + dataUsers[i].id + '>'
								+ dataUsers[i].firstName + ' '
								+ dataUsers[i].lastName + '</option>');
			})
			$('.listUsers').append('</select>');
		} else {
			$('.listUsers').empty();
		}
	});
}
function getUser(id) {
	var url = "http://localhost:8080/users/user/" + id + "/";
	var request = $.ajax
	  ({
		    type: "GET",
		    url: url,
		    dataType: 'json',
		    async: false,
		    beforeSend: function (xhr) {
		        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
		    },
		});
	request.done(function(data) {
		$(".photoUsers").attr("src", "localhost:8080/file:///D:/My%20Projects/Library/src/main/resources/image/andreev@gmail.com.png");
		$(".nameUsers").text(data.firstName + "  " + data.lastName);
	});
}
function getAllUsers() {
	var url = "http://localhost:8080/users/all";
	var request = $.ajax
	  ({
		    type: "GET",
		    url: url,
		    dataType: 'json',
		    async: false,
		    beforeSend: function (xhr) {
		        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
		    },
		});
	request.done(function(dataUsers) {
				if (dataUsers.length >= 0) {
					$.each(dataUsers,function view(i) {
										$('.allUsers').append('<div class="users userItemAll'+ i + '"></div>');
										$('.userItemAll' + i).append('<div style="margin-top:5px"><div class="firstName User">'+ dataUsers[i].firstName+ '</div>');
										$('.userItemAll' + i).append('<div class="lastName User">'+ dataUsers[i].lastName+ '</div>');
										$('.userItemAll' + i).append('<div class="Email User">'+ dataUsers[i].email+ '</div>');
										$('.userItemAll' + i).append('<a href="#user" id="userHref'+ i+ '" class="portfolio-link" data-toggle="modal"><button type="submit" style="font-size: 12px; padding: 4px 5px;" id="btnUser" class="btn btn-xl">browsing</button></a></div>');
										$('#userHref' + i + '').bind('click',function() {getUser(dataUsers[i].id);getbooksUser(dataUsers[i].id);})
									});
				} else {
					$('.allUsers').empty();
				}
			});
}
function getBook(id) {
	var url = "http://localhost:8080/books/book/" + id + "/";
	var request = $.ajax
	  ({
		    type: "GET",
		    url: url,
		    dataType: 'json',
		    async: false,
		    beforeSend: function (xhr) {
		    	
		        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
		    },
		});
	request.done(function(dataBooks) {
		if (dataBooks) {
			$(".titleBook").text(dataBooks.title);
			$(".publishingHouseBook").text(dataBooks.publishingHouse);
			$(".pageNumberBook").text(dataBooks.pageNumber);
			$(".yearsBook").text(dataBooks.years);
		} else {
			$(".titleBook").empty();
			$(".publishingHouseBook").empty();
			$(".pageNumberBook").empty();
			$(".yearsBook").empty();
		}
	});
}
function getAllBooks() {
	var url = "http://localhost:8080/books/all";
	var request = $.ajax
	  ({
		    type: "GET",
		    url: url,
		    dataType: 'json',
		    async: false,
		    beforeSend: function (xhr) {
		    	xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
		    },
		});
	request.done(function(dataBooks) {if (dataBooks.length > 0) {
		$.each(dataBooks,function view(i) {
										$('.allBooks').append('<div style="margin-top:5px"<div class="books bookItemAll'+ i + '"></div>');
										$('.bookItemAll' + i).append('<div class="title Book">'+ dataBooks[i].title+ '</div>');
										$('.bookItemAll' + i).append('<div class="author Book">'+ dataBooks[i].author+ '</div>');
										$('.bookItemAll' + i).append('<div class="publishingHouse Book">'+ dataBooks[i].publishingHouse+ '</div>');
										$('.bookItemAll' + i).append('<div class="years Book">'+ dataBooks[i].years+ '</div>');
										$('.bookItemAll' + i).append('<div class="pageNumber Book">'+ dataBooks[i].pageNumber+ '</div>');
										var url = "http://localhost:8080/book/status/"
												+ dataBooks[i].id + "/";
										var request =$.ajax
										  ({
											    type: "GET",
											    url: url,
											    dataType: 'json',
											    async: false,
											    beforeSend: function (xhr) {
											        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
											    },
											});
										request.done(function(dataBookInUse) {
														switch (dataBookInUse.bookStatus) {
														case 1:
															$('.bookItemAll'+ i).append('<div class="nameStatus Book"><span> на руках</span></div></div>');
															break;
														case 2:
															$('.bookItemAll'+ i).append('<div class="nameStatus Book"><span> в читальном зале</span></div></div>');
															break;
														case 3:
															$('.bookItemAll'+ i).append('<div class="nameStatus Book"><span> забронирована</span></div></div>');
															break;
														default:
															break;
														}
													
												})
										request.fail(function () {
													$('.bookItemAll' + i).append('<div class="nameStatus Book"><span>в ниличии</span></div>');
													if(role=="ROLE_USER"){
														$('.bookItemAll' + i).append('<button type="submit" id="bookHref'+ i+ '" style="font-size: 12px; padding: 4px 5px;" class="btn btn-xl">Reserve</button></div>');
														$('#bookHref' + i + '').bind('click', function () {
														    var url = "http://localhost:8080/user/takeBook";
														    var id_user = $.cookie("userInfoid");
														    var id_book = dataBooks[i].id;
														    var status = "3";
														    var DateTake = new Date();
														    var month = Number(DateTake.getMonth()) + 1;
														    var years = Number(DateTake.getFullYear());
														    if (month > 12) {
														        month = 1;
														        years = years + 1;
														    }
														    var endDate = '' + years + '-' + month+ '-'+ DateTake.getDate()+ '';
														    var startDate = ''+ DateTake.getFullYear()+ '-'+ DateTake.getMonth()+ '-'+ DateTake.getDate()
				                                                    + '';
														    var JSONObject = {
														        "id": 1,
														        "id_book": id_book,
														        "id_user": id_user,
														        "bookStatus": status,
														        "startDate": startDate,
														        "endDate": endDate
														    };
														    takeBook(JSONObject);
													})
													}
										})
										
		});
				} else {
					$('.allBooks').empty();
				}
			});
}
function userLogin(e, emailUss, passwordUss) {
	e.preventDefault();
	$('#errorlogin').hide();
	var JSONObject = {
		"password" : passwordUss,
		"email" : emailUss,
	}
	var request = $.ajax({
		contentType : 'application/json',
		url : "http://localhost:8080/user/login/",
		type : "POST",
		data : JSON.stringify(JSONObject),
		dataType : "json"
	});
	request.success(function(data) {
		user = data;
		$.cookie("userInfo", user.email +":"+ user.password, {
			expires : 7
		});
		$.cookie("userInfoid", user.id, {
			expires : 7
		});
		$.cookie("role", user.role, {
			expires : 7
		});
		if ($.cookie("userInfo") != null) {
			$('#regist').hide();
			$('#login').hide();
			$('#exit').show();
			$('.nav li').show()
		}
		if (user != null) {
			getbooksUser(data.id);
			if (role == "ROLE_ADMIN") {
				$(".user").hide();
			}
			if (role == "ROLE_USER") {
				$(".librarian").hide();
			}
		}
		location.reload();
	});
	request.fail(function (){ 
		$('#errorlogin').show();
	})
}
function getbooksUser(id) {
	var url = "http://localhost:8080/books/user/" + id + "/"
	var posting = $.ajax({
		contentType : 'application/json',
		url : url,
		type : "POST",
		beforeSend: function (xhr) {
	        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
	        },
		dataType : "json"
	});
	var idUser = id;
	posting.done(function getBooksUser(dataBooks) {
				if (dataBooks.length > 0) {
					$('.booksUser').empty();
					$.each(dataBooks,function view(i) {
										$('.booksUser').append('<div style="margin-top:5px;"><div class="books bookItem'+ i + '"></div>');
										$('.bookItem' + i).append('<div class="title Book">'+ dataBooks[i].title+ '</div>');
										$('.bookItem' + i).append('<div class="author Book">'+ dataBooks[i].author+ '</div>');
										$('.bookItem' + i).append('<div class="publishingHouse Book">'+ dataBooks[i].publishingHouse+ '</div>');
										$('.bookItem' + i).append('<div class="years Book">'+ dataBooks[i].years+ '</div>');
										$('.bookItem' + i).append('<div class="pageNumber Book">'+ dataBooks[i].pageNumber+ '</div></div>');
										$('#refBook'+ i).bind('onload',function(){
											getBook(dataBooks[i].id);
										})
										if (role == "ROLE_ADMIN"){
											$('.bookItem' + i).append('<div class="librarian"><button type="bottom" style="font-size: 12px; padding: 4px 5px;" id="btnPassBook'+ i + '" class="btn btn-xl">Pass</button></div></div>');
										$('#btnPassBook' + i).bind('click',
												function() {
															var JSONObject = {
																"id_user" : idUser,
																"id_book" : dataBooks[i].id
															};
															var request = $.ajax({
																		contentType : 'application/json',
																		url : "http://localhost:8080/user/passBook",
																		type : "DELETE",
																		beforeSend: function (xhr) {
																	        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
																	        },
																		data : JSON.stringify(JSONObject),
																		dataType : "json"
																	});
															request.done($('.bookItem'+ i).empty());
														})
										}
										else {$('.bookItem' + i).append('</div>');}
									});
				} else {
					$('.booksUser').empty();
				}
			});
}
$('#dateTakeBook').focusout(function() {
	var DateTake = new Date($('#dateTakeBook').val());
	var month = Number(DateTake.getMonth()) + 2;
	var years = Number(DateTake.getFullYear());
	if (month > 12) {
		month = 1;
		years = years + 1;
	}
	var endDate = '' + DateTake.getDate() + '.' + month + '.' + years + '';
	$('#endDate').show();
	$('#endDate').val(endDate);
});
$('#btnTakeBook').click(
		function() {
			var id_user = $('.listUsersItem option:selected').val();
			var id_book = $('.listBooksItemLib option:selected').val();
			var status = "1";
			var DateTake = new Date($('#dateTakeBook').val());
			var month = Number(DateTake.getMonth()) + 1;
			var years = Number(DateTake.getFullYear());
			if (month > 12) {
				month = 1;
				years = years + 1;
			}
			var endDate = '' + years + '-' + month + '-' + DateTake.getDate()
					+ '';
			var startDate = '' + DateTake.getFullYear() + '-'
					+ DateTake.getMonth() + '-' + DateTake.getDate() + '';
			var JSONObject = {
				"id" : 1,
				"id_book" : id_book,
				"id_user" : id_user,
				"bookStatus" : status,
				"startDate" : startDate,
				"endDate" : endDate
			};
			takeBook(JSONObject);
		});
function takeBook(JSONObject) {
	
	var request = $.ajax({
		contentType : 'application/json',
		url : "http://localhost:8080/user/takeBook",
		type : "POST",
		data : JSON.stringify(JSONObject),
	    beforeSend: function (xhr) {
	        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
	    },
		dataType : "json"
	});
	request.always(function () {window.location.reload();});
}
$('#btnSearchBook').click(function () {
    var searchTitle = $("#searchTitle").val();
    var searchAuthor = $("#searchAuthor").val();
    var JSONObjectUser = {
        "title": searchTitle,
        "author": searchAuthor,
    };
    var request = $.ajax({
        contentType: 'application/json',
        url: "http://localhost:8080/books/book/search",
        type: "POST",
        beforeSend: function (xhr) {
	        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
	        },
        data: JSON.stringify(JSONObjectUser),
        dataType: "json"
    });
    request.done(function (dataBooks) {
    	var key = "Lib";
    	searchBook(dataBooks,key);
    })
})

$('#btnSearchForUserBook').click(function () {
    var searchTitle = $("#searchForUserTitle").val();
    var searchAuthor = $("#searchForUserAuthor").val();
    var JSONObjectUser = {
        "title": searchTitle,
        "author": searchAuthor,
    };
    var request = $.ajax({
        contentType: 'application/json',
        url: "http://localhost:8080/books/book/search",
        type: "POST",
        beforeSend: function (xhr) {
	        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
	        },
        data: JSON.stringify(JSONObjectUser),
        dataType: "json"
    });
    request.done(function (dataBooks) {
    	var key = "User";
    	searchBook(dataBooks,key);
    })
})

function searchBook(dataBooks,key){
    	if (dataBooks.length > 0) {
            $('.listBooks'+ key).empty();
            $('.listBooks' + key).append('<select size="5"  class="form-control listBooksItem'+key+'">');
            $('.listBooksItem' + key).empty();
            $.each(dataBooks, function view(i) {
                var url = "http://localhost:8080/book/status/" + dataBooks[i].id + "/";
                var request = $.ajax
                ({
            	    type: "GET",
            	    url: url,
            	    dataType: 'json',
            	    async: false,
            	    beforeSend: function (xhr) {
            	        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
            	    },
            	});
                request.done(function (dataBookInUse) {
                        switch (dataBookInUse.bookStatus) {
                            case 1:
                                $('.listBooksItem'+key).append('<option value='
                                                        + dataBooks[i].id + '>'
                                                        + dataBooks[i].title + '  '
                                                        + dataBooks[i].author + '<span> на руках</span></option>');
                                break;
                            case 2:
                                $('.listBooksItem'+key).append('<option value='
                                                        + dataBooks[i].id + '>'
                                                        + dataBooks[i].title + '  '
                                                        + dataBooks[i].author + '<span> в читальном зале</span></option>');
                                break;
                            case 3:
                                $('.listBooksItem'+key).append('<option value='
                                                        + dataBooks[i].id + '>'
                                                        + dataBooks[i].title + '  '
                                                        + dataBooks[i].author + '<span> забронирована</span></option>');
                                break;
                            default:
                                break;
                        }
                
                })
                request.fail(function () {
                	$('.listBooksItem'+key).append('<option value='
                            + dataBooks[i].id + '>'
                            + dataBooks[i].title + '  '
                            + dataBooks[i].author + '<span>в ниличии</span></option>');
				})
            })
            $('.listBooks'+key).append('</select>');
        } else {
            $('.listBooks'+key).empty();
        }
    }
$('#btnSearchUsers').click(function () {
    var searchEmail = $("#searchEmail").val();
    var searchFirstName = $("#searchFirstName").val();
    var searchLastName = $("#searchLastName").val();

    var JSONObjectUser = {
        "firstName": searchFirstName,
        "lastName": searchLastName,
        "email": searchEmail
    };
    var request = $.ajax({
        contentType: 'application/json',
        url: "http://localhost:8080/users/user/search",
        type: "POST",
        beforeSend: function (xhr) {
	        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
	    },
        data: JSON.stringify(JSONObjectUser),
        dataType: "json"
    });
    request.done(function (dataUsers) {
        if (dataUsers.length > 0) {
        	$('.listUsers').empty();
            $('.listUsers').append('<select size="5"  class="form-control listUsersItem">');
            $.each(dataUsers, function view(i) {
                $('.listUsersItem').append('<option value='
                                        + dataUsers[i].id
                                        + '>'
                                        + dataUsers[i].firstName
                                        + '  '
                                        + dataUsers[i].lastName
                                        + '  '
                                        + dataUsers[i].email
                                        + '</option>');
            })
            $('.listUsers').append('</select>');
        } else {
            $('.listUsers').empty();
        }
    })
})
$('#btnAddBook').click(function() {
	var titleBook = $("#title").val();
	var author = $("#author").val();
	var publishingHouse = $("#publishingHouse").val();
	var years = $("#years").val();
	var pageNumber = $("#pageNumber").val();
	var JSONObjectUser = {
		"id" : 1,
		"title" : titleBook,
		"author" : author,
		"publishingHouse" : publishingHouse,
		"years" : years,
		"pageNumber" : pageNumber
	};
	var request = $.ajax({
		contentType : 'application/json',
		url : "http://localhost:8080/books/add",
		type : "POST",
		beforeSend: function (xhr) {
	        xhr.setRequestHeader ("Authorization", "Basic " + btoa($.cookie("userInfo")));
	    },
		data : JSON.stringify(JSONObjectUser),
		dataType : "json"
	});
	request.done(location.reload());
})
$('#btnSendData').click(function(e) {
	var emailReg = $("#txtEmail").val();
	var passwordReg = $("#txtPassword").val();
	var firstNameReg = $("#txtFirstName").val();
	var lastNameReg = $("#txtLastName").val();
	var passwordAgain = $("#txtPasswordAgain").val();
	debugger;
	var role = "ROLE_USER";
	if (passwordReg != passwordAgain) {
		return;
		$('#errorRegistration').show();
	}
	var JSONObjectUser = {
		"id" : 1,
		"firstName" : firstNameReg,
		"lastName" : lastNameReg,
		"password" : passwordReg,
		"avatar" : file,
		"email" : emailReg,
		"role" : role
	};
	var request = $.ajax({
		contentType : 'application/json',
		url : "http://localhost:8080/user/add",
		type : "POST",
		data : JSON.stringify(JSONObjectUser),
		dataType : "json"
	});
	request.success(userLogin(e, emailReg, passwordReg))
	request.fail(function(){
		$('#errorRegistration').show();
	});
});
function readURL(e) {
	e.preventDefault();
	if (this.files && this.files[0]) {
		var reader = new FileReader();
		$(reader).load(function(e) {
			$('#imgLoad').attr('src', e.target.result);
			$('#imgLoad').css("display", "inline");
			file = e.target.result;
		});
		reader.readAsDataURL(this.files[0]);
	}
}
$("#flAvatar").change(readURL);

$("#exit").click(function() {
	$.cookie("userInfo", "null");
	$.cookie("userInfoid", "null");
	$.cookie("role", "null");
	location.reload();
});

$("#sendBtn").click(function(e) {
	var emailUs = $("#email").val();
	var passwordUs = $("#password").val();
	userLogin(e, emailUs, passwordUs);
});
