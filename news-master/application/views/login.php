<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Admin Login</title>
	<link href="<?=base_url()?>assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="<?=base_url()?>assets/css/datepicker3.css" rel="stylesheet">
	<link href="<?=base_url()?>assets/css/styles.css" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body style="background-color: black">
	<div class="row">
		<center>
		<a href="index.html"><img src="<?=base_url()?>assets/images/logo.png" class="img-responsive" alt="" width="250"/></a>
		</center>
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading" align="center">Admin</div>
				<div class="panel-body">
					<form action="<?=site_url('adminlogin/dologin');?>" method="POST" role="form">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Username" name="username" type="text" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="password" type="password" value="">
							</div>
							
							<button type="submit" class="btn btn-primary">Login</button></fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
	

<script src="<?=base_url()?>assets/js/jquery-1.11.1.min.js"></script>
	<script src="<?=base_url()?>assets/js/bootstrap.min.js"></script>
</body>
</html>
