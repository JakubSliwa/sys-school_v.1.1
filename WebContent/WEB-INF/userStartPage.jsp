<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello!</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/superhero/bootstrap.min.css">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
</head>

<body>
	<c:set var="systemUserId" value="${sessionScope['user_id']}" />

	<%@ include file="/parts/userHeader.jsp"%>
	<%
		String name = (String) session.getAttribute("systemUsername");
		String email = (String) session.getAttribute("systemUserEmail");
		Integer id = (Integer) session.getAttribute("systemUserId");
		String isSend = (String) request.getAttribute("isSend");
		
		
	%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 .col-sm-6 .col-lg-8" >
				<img alt="avatar"
					src="https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg"
					style="width: 180px; height: 180px display:inline-block">
			</div>
			<div class="col-xs-12 .col-sm-6 .col-lg-8">
				<div class="jumbotron" style="width:90vw">
					<a class="btn btn-info clickToShowSender">Send message</a> <a
						class="btn btn-info clickToShowMess">Recived messages</a> <a
						class="btn btn-info" >Check your tasks</a> <a
						class="btn btn-warning" >Settings</a> <a
						class="btn btn-danger" href="">Log out</a>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="alert alert-dismissible alert-success "
				id="messagesSuccessAfterSend" style="display: none;">
				<button type="button" class="close"
					id="clickToHideMessagesSuccessAfterSend" data-dismiss="alert">&times;</button>
				<strong>Well done!</strong> You successfully send a message.
			</div>
			<div class="alert alert-dismissible alert-primary"
				id="messagesErrorAfterSend" style="display: none;">
				<button type="button" class="close"
					id="clickToHideMessagesErrorAfterSend" data-dismiss="alert">&times;</button>
				<strong>Error!</strong> Message isn't send
			</div>
		</div>

	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 .col-sm-6 .col-lg-8">
				<div class="jumbotron">
					<form action="SendMessage" method="post">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div>
									<div class="modal-header clickToShowSender">
										<h5 class="modal-title">Send message to: &nbsp;</h5>
										<div class="form-group">
											<select class="custom-select" name="select">
												<option selected="">Open this select menu</option>
												<c:forEach items="${user}" var="user">
													<option value="${user.id}">${user.name}</option>
												</c:forEach>
											</select>
										</div>


									</div>
									<div id="hideSendMess">
										<div class="modal-body">
											<textarea id="text" class="form-control" rows="5"
												name="message" placeholder="write your message..."></textarea>

										</div>
										<div class="modal-footer">
											<div class="form-group">
												<button type="submit" class="btn btn-info"
													id="clickToShowIsSend">Send</button>
												<button type="button" class="btn btn-secondary"
													id="clickToHideSender" data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header clickToShowMess">
								<h5 class="modal-title">Recived messages</h5>

							</div>
							<div id="hideGetMess">
								<div class="modal-body">
									<ul class="list-group">
										<c:forEach items="${recivedMessages}" var="messages">
												<li
											class="list-group-item d-flex justify-content-between align-items-center">
												<div class="card">
												  <div class="card-body">
												    <h4 class="card-title">From: ${messages.addedBy}</h4>
												    <h6 class="card-subtitle mb-2 text-muted">${messages.date}</h6>
												    <p class="card-text">${messages.text}</p>													
												  </div>
												  <div class="card-footer text-muted">
												    <a href="DeleteMessage?id=${messages.id}" class="card-link">Delete</a>
												  </div>
												</div>
											</li>	
										</c:forEach>
									
										
									</ul>
								</div>
								<div class="modal-footer">
									<button type="button" id="clickToHideMess"
										class="btn btn-secondary" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-content">
						<div>
							<div class="modal-header" id="clickToShowPom">
								<h5 class="modal-title">PomotoroTimer</h5>
								<img alt="pomodoro"
									src="https://pomodorolist.herokuapp.com/assets/logo-f21322f28fc1958cc7823b19af6bee3b297d088d7e2a2842350968b8875ec3cc.png"
									style="width: 50px; height: 50px display:inline-block">

							</div>
							<div id="hidePomodoro">
								<div class="modal-body text-center">
									<h2>15:00</h2>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-info">
										PomodoroTime!</button>
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Stop</button>
									<button type="button" id="clickToHidePomodoro"
										class="btn btn-secondary" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="modal-content">
						<div>
						<h5 class="modal-header" id="clickToShowToDo">To do list</h5>
						<div id="hideToDo">
							<div class="modal-body">
								<h5 class="modal-title">Add new task</h5>
								<h6 class="modal-subtitle text-muted">Show all tasks</h6>
								<div class="modal-dialog" role="document">

									<div>
										<ul class="list-group">
											<li
												class="list-group-item d-flex justify-content-between align-items-center">
												Zadanie 1 <span><input class="form-check-input"
													value="" checked="" type="checkbox"></span>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center">
												Zadanie 2 <span><input class="form-check-input"
													value="" checked="" type="checkbox"></span>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center">
												Zadanie 3 <span><input class="form-check-input"
													value="" checked="" type="checkbox"></span>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-success">Check done tasks!</button>
								<button type="button" id="clickToHideToDo"
									class="btn btn-secondary" data-dismiss="modal">Close</button>
							</div>
						</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xs-12 .col-sm-6 .col-lg-8">
				<div class="jumbotron" style="width:50vw">
					<table class="table table-hover">
						<tr align="center">
							<th>Id</th>
							<th>Title</th>
							<th>Description</th>
							<th></th>
						
						</tr>
						<c:forEach items="${exercise}" var="exercise">
							<tr align="center">
								<td>${exercise.id}</td>
								<td>${exercise.title}</td>
								<td>${exercise.description}</td>
								<td><a class="btn btn-primary" href="AddNewSolution">Submit answer</a>

							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
		



			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
				  <script src="//code.jquery.com/jquery-1.12.4.js"></script>
 				 <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
				
			<script>
				$(function() {
					$('#hidePomodoro').hide()
					$('#clickToShowPom').on('click', function() {
						if ($('#hidePomodoro').css('display') === 'none') {
							$('#hidePomodoro').fadeIn('slow');
						}
					});

					$('#clickToHidePomodoro').on('click', function() {
						if ($('#hidePomodoro').css('display') !== 'none') {
							$('#hidePomodoro').fadeOut('slow');
						}
					});

					$('#hideToDo').hide()
					$('#clickToShowToDo').on('click', function() {
						if ($('#hideToDo').css('display') === 'none') {
							$('#hideToDo').fadeIn('slow');
						}
					});
					$('#clickToHideToDo').on('click', function() {
						if ($('#hideToDo').css('display') !== 'none') {
							$('#hideToDo').fadeOut('slow');
						}
					});

					$('#hideSendMess').hide()
					$('.clickToShowSender').on('click', function() {
						if ($('#hideSendMess').css('display') === 'none') {
							$('#hideSendMess').fadeIn('slow');
						}
					});
					$('#clickToHideSender').on('click', function() {
						if ($('#hideSendMess').css('display') !== 'none') {
							$('#hideSendMess').fadeOut('slow');
						}
					});

					$('#hideGetMess').hide()
					$('.clickToShowMess').on('click', function() {
						if ($('#hideGetMess').css('display') === 'none') {
							$('#hideGetMess').fadeIn('slow');
						}
					});
					$('#clickToHideMess').on('click', function() {
						if ($('#hideGetMess').css('display') !== 'none') {
							$('#hideGetMess').fadeOut('slow');
						}fl
					});
					var test = '<%=isSend%>';
					console.log(test)
					

					$('#clickToShowIsSend').on('click',function() {
								console.log(test);
								var test ='<%=isSend%>';
								if (test == "yes" || $('#messagesSuccessAfterSend').css('display') === 'none') {
									$('#messagesSuccessAfterSend').toggle("slide");
									console.log("1." +test);
									
								}else if(test == "no" && ($('#messagesErrorAfterSend').css('display') === 'none')) {
									$('#messagesErrorAfterSend').toggle("slide");
									console.log("2." +test);
								}
								console.log("3." +test);
							});

					
			
					$('#clickToHideMessagesSuccessAfterSend').on('click',function() {
								if ($('#messagesSuccessAfterSend').css('display') !== 'none') {
									$('#messagesSuccessAfterSend').fadeOut('slow');
								}
							});

					$('#clickToHideMessagesErrorAfterSend').on('click',function() {
										if ($('#messagesErrorAfterSend').css('display') !== 'none') {
											$('#messagesErrorAfterSend').fadeOut('slow');
										}
									});

				});
			</script>


			<%@ include file="/parts/userFooter.jsp"%>
</body>

</html>
