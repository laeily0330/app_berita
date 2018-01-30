<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Adminlogin extends CI_Controller {

	public function index()
	{
		$this->load->view('login');
	}
	public function dologin(){
		$username = $this->input->post('username');
		$password = $this->input->post('password');

		$login = $this->m_global->adminlogin($username,$password);

		if ($login->num_rows() == 1) {
			foreach ($login->result() as $sess) {
				$sess_data['logged_in'] = 'LogIn';
				$sess_data['id_login'] = $sess->id_admin;
				$sess_data['username'] = $sess->username;
			}

			$this->session->set_userdata('logged_in',$sess_data);
			redirect('admin','refresh');
		}
		else{
			redirect(site_url('adminlogin'),'refresh');
		}
	}

	public function logout(){
		$this->session->sess_destroy();
		redirect('adminlogin','refresh');
	}

}

/* End of file Adminlogin.php */
/* Location: ./application/controllers/Adminlogin.php */