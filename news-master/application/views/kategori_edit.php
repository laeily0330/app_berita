<?php $this->load->view('master/header'); ?>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
      <ol class="breadcrumb">
        <li><a href="#">
          <em class="fa fa-home"></em>
        </a></li>
        <li class="active">Kategori</li>
        <li class="active">Edit Kategori</li>
      </ol>
    </div><!--/.row-->
    
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">Edit Kategori</h1>
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
                <form action="<?=site_url('admin/kategori_doedit/').$key->id_kategori;?>" method="POST" role="form">
                  <div class="form-group">
                  <input type="text" class="form-control" id="" placeholder="Nama" name="nama_kategori" value="<?=$key->nama_kategori;?>">
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