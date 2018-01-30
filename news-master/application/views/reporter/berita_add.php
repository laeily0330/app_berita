<?php $this->load->view('reporter/header'); ?>
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
      <ol class="breadcrumb">
        <li><a href="#">
          <em class="fa fa-home"></em>
        </a></li>
        <li class="active">Publikasi</li>
        <li class="active">Add Berita</li>
      </ol>
    </div><!--/.row-->
    
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">Add Berita</h1>
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
                              
                <form action="<?=site_url('reporter/berita_doadd');?>" method="POST" role="form" enctype="multipart/form-data">
                  <div class="form-group">
                      <label for="">Kategori</label>
                      <select name="kategori"  class="form-control" required="required">
                        <?php foreach ($kategori as $key) {
                          ?>
                            <option value="<?=$key->id_kategori?>"> <?=$key->nama_kategori?></option>
                        <?php 
                        } ?>
                   </select>
                   </div>
                <div class="form-group">
                  <input type="text" class="form-control" id="" placeholder="Judul" name="judul" >
                </div>
                <div class="form-group">
                      <label for="">Gambar</label>
                      <input type="file" name="gambar" size="100"/>
                  </div>  
                <div class="form-group">
                  <textarea name="isi" id="input" class="form-control" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
              
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
  <?php $this->load->view('reporter/footer'); ?>