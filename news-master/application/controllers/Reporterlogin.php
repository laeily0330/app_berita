<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Reporterlogin extends CI_Controller {

	
	public function index()
	{
		$this->load->view('reporter/login');
	}
	public function dologin(){
		$username = $this->input->post('username');
		$password = $this->input->post('password');

		$login = $this->m_global->reporterlogin($username,$password);

		if ($login->num_rows() == 1) {
			foreach ($login->result() as $sess) {
				$sess_data['logged_in2'] = 'LogIn';
				$sess_data['id_reporter'] = $sess->id_reporter;
				$sess_data['username'] = $sess->username;
				$sess_data['nama_reporter'] = $sess->nama_reporter;
			}

			$this->session->set_userdata('logged_in2',$sess_data);
			redirect('reporter','refresh');
		}
		else{
			redirect(site_url('reporterlogin'),'refresh');
		}
	}

	public function logout(){
		$this->session->sess_destroy();
		redirect('reporterlogin','refresh');
	}

}

/* End of file Reporterlogin.php */
/* Location: ./application/controllers/Reporterlogin.php */