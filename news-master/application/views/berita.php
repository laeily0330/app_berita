<?php $this->load->view('master/header'); ?>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
      <ol class="breadcrumb">
        <li><a href="#">
          <em class="fa fa-home"></em>
        </a></li>
        <li class="active">Berita</li>
      </ol>
    </div><!--/.row-->
    
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">Berita</h1>
      </div>
    </div><!--/.row-->
    <div class="row">
      <div class="col-md-12">
        <div class="panel panel-default chat">
          <div class="panel-heading">
            
            </div>
          <div class="panel-body">
            <ul>


              <table class="table table-bordered table-hover">
              	<thead>
              		<tr>
              			<th>No</th>
              			<th>Nama Reporter</th>
              			<th>Kategori</th>
                    <th>Judul</th>
              			<th>Gambar</th>
              			<th>Isi</th>
              			<th>Tanggal</th>
              			<th>Action</th>
              		</tr>
              	</thead>
               <?php 
              $a = 1;
              foreach ($tampil as $key) 
              {?>
              	<tbody>

              		<tr>
              			<td><?=$a++ ?></td>
              			<td><?=$key->nama_reporter ;?></td>
              			<td><?=$key->nama_kategori ;?></td>
                    <td><?=$key->judul ;?></td>
              			<td><img src="<?=base_url()?>uploads/original/<?=$key->gambar ;?>" class="img-responsive" alt="Image"></td>
              			<td><?=$key->isi ;?></td>
              			<td><?=$key->tanggal ;?></td>
              			<td>
                      <a href="<?=site_url('admin/berita_delete/').$key->id_isi;?>"><em class="fa fa-trash"></em></a>    
                    </td>
              		</tr>
              	</tbody>
                <?php } ?>
              </table>
              
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