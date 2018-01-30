<?php $this->load->view('master/header'); ?>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
      <ol class="breadcrumb">
        <li><a href="#">
          <em class="fa fa-home"></em>
        </a></li>
        <li class="active">Reporter</li>
        <li class="active">Edit Reporter</li>
      </ol>
    </div><!--/.row-->
    
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">Edit Reporter</h1>
      </div>
    </div><!--/.row-->
    <div class="row">
      <div class="col-md-12">
        <div class="panel panel-default chat">
          <div class="panel-heading">
            </div>
          <div class="panel-body">
            <ul>
              <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                 <?php foreach ($tampil as $key) {?>
                <form action="<?=site_url('admin/reporter_doedit/').$key->id_reporter;?>" method="POST" role="form">
                  <div class="form-group">
                  <input type="text" class="form-control" id="" placeholder="Nama" name="nama_reporter" value="<?=$key->nama_reporter?>">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" id="" placeholder="Alamat" name="alamat" value="<?=$key->alamat?>">
                </div>
                <div class="form-group">
                  <input type="date" class="form-control" id="" placeholder="Tanggal Lahir" name="tanggal_lahir" value="<?=$key->tanggal_lahir?>">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" id="" placeholder="Username" name="username" value="<?=$key->username?>">
                </div>
                <div class="form-group">
                  <input type="password" class="form-control" id="" placeholder="Password" name="password" value="<?=$key->password?>">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
              <?php } ?>
              </div>
            </ul>
          </div>
          <!-- <div class="panel-footer">
            <div class="input-group">
              <input id="btn-input" type="text" class="form-control input-md" placeholder="Type your message here..." /><span class="input-group-btn">
                <button class="btn btn-primary btn-md" id="btn-chat">Send</button>
            </span></div>
          </div> -->
        </div> 
    </div><!--/.row-->
  </div>  <!--/.main-->
<?php $this->load->view('master/footer'); ?>