<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Admin extends CI_Controller {
	var $API ="";
	function __construct() {
		 parent::__construct();
		 if (!$this->session->userdata('logged_in')=="LogIn") {
				redirect('adminlogin','refresh');
				
			}
	 }
	public function index()
	{
		$data['tampil'] = $this->m_global->tampil('admin','id_admin');
		$this->load->view('admin',$data);
	}
	public function admin_edit($id)
	{
		$data['tampil'] = $this->m_global->tampil_id($id,'admin','id_admin');
		$this->load->view('admin_edit',$data);
	}
	public function admin_doedit($id)
	{
		$data = array(
						'username' => $this->input->post('username'),
						'password' => $this->input->post('password')
					);
			$this->m_global->edit($id,'admin',$data,'id_admin');
			redirect('admin','refresh');
	}
	public function reporter()
	{
		$data['tampil'] = $this->m_global->tampil('reporter','id_reporter');
		$this->load->view('reporter',$data);
	}
	public function reporter_add()
	{
		$this->load->view('reporter_add');
	}
	public function reporter_doadd()
	{
		$data = array(
						'nama_reporter' => $this->input->post('nama_reporter'),
						'alamat' => $this->input->post('alamat'),	
						'tanggal_lahir' => $this->input->post('tanggal_lahir'),
						'username' => $this->input->post('username'),
						'password' => $this->input->post('password')
					);
			$this->m_global->tambah('reporter',$data);
			redirect('admin/reporter','refresh');
	}
	public function reporter_edit($id)
	{
		$data['tampil'] = $this->m_global->tampil_id($id,'reporter','id_reporter');
		$this->load->view('reporter_edit',$data);
	}
	public function reporter_doedit($id)
	{
		$data = array(
						'nama_reporter' => $this->input->post('nama_reporter'),
						'alamat' => $this->input->post('alamat'),	
						'tanggal_lahir' => $this->input->post('tanggal_lahir'),
						'username' => $this->input->post('username'),
						'password' => $this->input->post('password')
					);
			$this->m_global->edit($id,'reporter',$data,'id_reporter');
			redirect('admin/reporter','refresh');
	}
	public function reporter_delete($id){
		$this->m_global->hapus($id,'reporter','id_reporter');
		redirect('admin/reporter','refresh');
	}
	public function user()
	{
		$data['tampil'] = $this->m_global->tampil('user','id_user');
		$this->load->view('user',$data);
	}
	public function user_delete($id)
	{
		$this->m_global->hapus($id,'user','id_user');
		redirect('admin/user','refresh');
	}
	public function berita()
	{
		$data['tampil'] = $this->m_global->tampil_isi(); 
		$this->load->view('berita',$data);
	}
	public function berita_delete()
	{
		$this->m_global->hapus($id,'isi','id_isi');
		redirect('admin/berita','refresh');
	}
	public function kategori()
	{
		$data['tampil'] = $this->m_global->tampil('kategori','id_kategori'); 
		$this->load->view('kategori',$data);
	}
	public function kategori_add()
	{
		$this->load->view('kategori_add');
	}
	public function kategori_doadd()
	{
		$data = array(
						'nama_kategori' => $this->input->post('nama_kategori')
					);
			$this->m_global->tambah('kategori',$data);
			redirect('admin/kategori','refresh');
	}
	public function kategori_edit($id)
	{
		$data['tampil'] = $this->m_global->tampil_id($id,'kategori','id_kategori');
		$this->load->view('kategori_edit',$data);
	}
	public function kategori_doedit($id)
	{
		$data = array(
						'nama_kategori' => $this->input->post('nama_kategori')
					);
			$this->m_global->edit($id,'kategori',$data,'id_kategori');
			redirect('admin/kategori','refresh');
	}
	public function kategori_delete($id){
		$this->m_global->hapus($id,'kategori','id_kategori');
		redirect('admin/kategori','refresh');
	}
}

/* End of file Home.php */
/* Location: ./application/controllers/Home.php */