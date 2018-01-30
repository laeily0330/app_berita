<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Reporter extends CI_Controller {

	var $data;
	var $API ="";
	function __construct() {
		 parent::__construct();
		 $this->load->library('session');
		if($this->session->userdata('logged_in2')){
			$sess_data = $this->session->userdata('logged_in2');
			$this->data = array(
				'id_reporter' => $sess_data['id_reporter'],
				'username' => $sess_data['username'],
				'nama_reporter' => $sess_data['nama_reporter']
			);

		}else{
			redirect('reporterlogin','refresh');
		}
		 
	 }
	public function index()
	{
		$data = $this->data;
		$id = $data['id_reporter'];
		$data['tampil'] = $this->m_global->tampil_isi_reporter($id);
		$this->load->view('reporter/home',$data);
	}
	public function berita_add()
	{
		$data = $this->data;
		$data['kategori'] = $this->m_global->tampil('kategori','id_kategori');
		$this->load->view('reporter/berita_add',$data);
	}
	public function berita_doadd()
	{
			$data = $this->data;
			$foto = "IMG_".time();
			$config['upload_path'] = './uploads/original';
	        $config['allowed_types'] = 'jpg|jpeg|png';
	        $config['max_size']      = '1024';
	        $config['file_name'] = $foto;

	        $this->load->library('upload', $config);
	        $image_data = $this->upload->data();

	        if (! $this->upload->do_upload('gambar')){ // name="upload"
				echo $this->upload->display_errors();
		 	}else{

	            $image_data 				= $this->upload->data();
	            $dat['id_reporter'] 		= $data['id_reporter'];
	            $dat['id_kategori'] 		= $this->input->post("kategori");
	            $dat['judul'] 				= $this->input->post("judul");
	            $dat['gambar'] 				= $image_data['file_name'];
	            $dat['isi'] 				= $this->input->post("isi");
	            $dat['tanggal'] 			= date('Y-m-d');
		 		

	            $this->m_global->tambah('isi',$dat);

	            $config['source_image'] 	= $image_data['full_path'];
	            $config['new_image']      	= './uploads/kecil';
	            $config['maintain_ratio'] 	= true;
	            $config['width']          	= 100;
	            $config['height']         	= 180;

	            // kemudian panggil fungsi initialize() sebelum fungsi resize()
	            // kalau tidak, hanya akan menghasilkan 1 file saja
	            $this->image_lib->initialize($config);
	            $this->image_lib->resize();

	            redirect('reporter','refresh');
			}
	}
	public function berita_edit($id)
	{
		$data = $this->data;
		$data['kategori'] = $this->m_global->tampil('kategori','id_kategori');
		$data['tampil'] = $this->m_global->tampil_id($id,'isi','id_isi');
		$this->load->view('reporter/berita_add',$data);
	}
	public function berita_doedit()
	{
			$data = $this->data;
			$foto = "IMG_".time();
			$config['upload_path'] = './uploads/original';
	        $config['allowed_types'] = 'jpg|jpeg|png';
	        $config['max_size']      = '1024';
	        $config['file_name'] = $foto;

	        $this->load->library('upload', $config);
	        $image_data = $this->upload->data();

	        if (! $this->upload->do_upload('gambar')){ // name="upload"
				echo $this->upload->display_errors();
		 	}else{

	            $image_data 				= $this->upload->data();
	            $dat['id_reporter'] 		= $data['id_reporter'];
	            $dat['id_kategori'] 		= $this->input->post("kategori");
	            $dat['judul'] 				= $this->input->post("judul");
	            $dat['gambar'] 				= $image_data['file_name'];
	            $dat['isi'] 				= $this->input->post("isi");
	            $dat['tanggal'] 			= date('Y-m-d');
		 		

	            $this->m_global->tambah('isi',$dat);

	            $config['source_image'] 	= $image_data['full_path'];
	            $config['new_image']      	= './uploads/kecil';
	            $config['maintain_ratio'] 	= true;
	            $config['width']          	= 100;
	            $config['height']         	= 180;

	            // kemudian panggil fungsi initialize() sebelum fungsi resize()
	            // kalau tidak, hanya akan menghasilkan 1 file saja
	            $this->image_lib->initialize($config);
	            $this->image_lib->resize();

	            redirect('reporter','refresh');
			}
	}

}

/* End of file Reporter.php */
/* Location: ./application/controllers/Reporter.php */