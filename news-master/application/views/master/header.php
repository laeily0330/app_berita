<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>NEWS</title>
  <link href="<?=base_url()?>assets/css/bootstrap.min.css" rel="stylesheet">
  <!-- <link href="<?=base_url()?>assets/css/font-awesome.min.css" rel="stylesheet"> -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="<?=base_url()?>assets/css/datepicker3.css" rel="stylesheet">
  <link href="<?=base_url()?>assets/css/styles.css" rel="stylesheet">
  
  <!--Custom Font-->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
  <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span></button>
        <a class="navbar-brand" href="#"><span>KJN</span>NEWS</a>
        <ul class="nav navbar-top-links navbar-right">
        
        </ul>
      </div>
    </div><!-- /.container-fluid -->
  </nav>
  <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <div class="profile-sidebar">
      <div class="profile-userpic">
        <img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
      </div>
      <div class="profile-usertitle">
        
        <div class="profile-usertitle-name">Hi, Admin</div>
        <div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="divider"></div>
    <form role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
    </form>
    <ul class="nav menu">
      <li><a href="<?=site_url('admin')?>"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
      <li><a href="<?=site_url('admin/kategori')?>"><em class="fa fa-gears">&nbsp;</em> Kategori</a></li>
      <li><a href="<?=site_url('admin/reporter')?>"><em class="fa fa-user-circle">&nbsp;</em> Reporter</a></li>
      <li><a href="<?=site_url('admin/user')?>"><em class="fa fa-user-circle">&nbsp;</em> User</a></li>
      <li><a href="<?=site_url('admin/berita')?>"><em class="fa fa-newspaper-o">&nbsp;</em> Berita</a></li>
      <li><a href="<?=site_url('adminlogin/logout')?>"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
    </ul>
  </div><!--/.sidebar-->