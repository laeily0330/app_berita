<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class m_global extends CI_Model {

	public function tampil($tabel,$primary_key){
		$this->db->from($tabel);
		$this->db->order_by($primary_key, 'DESC');
		$query = $this->db->get(); 
		return $query->result();
	}	

	public function tampil_id($id,$tabel,$primary_key){
		$this->db->where($primary_key, $id);
		return $this->db->get($tabel)->result();
	}

	public function tambah($tabel,$data){
		$this->db->insert($tabel,$data);

	}
	
	public function edit($id,$tabel,$data,$primary_key){
		$this->db->where($primary_key,$id);
		$this->db->update($tabel,$data);
	
	}

	public function hapus($id,$tabel,$primary_key){
		$this->db->where($primary_key, $id);
		$this->db->delete($tabel);
	}

	public function tampil_file($tabel,$primary_key,$id){
		$this->db->where($primary_key, $id);
		$query = $this->db->get($tabel);
		if ($query->num_rows()==1) {
			return $query->row();
		}
	}

	public function login($username, $password){
		$data = array(
				'username' => $username,
				'password' => $password
			);
		
		$this->db->where($data);
		return $this->db->get('user');
	}
	
	public function adminlogin($username, $password){
		$data = array(
				'username' => $username,
				'password' => $password
			);
		
		$this->db->where($data);
		return $this->db->get('admin');
	}
	public function reporterlogin($username, $password){
		$data = array(
				'username' => $username,
				'password' => $password
			);
		
		$this->db->where($data);
		return $this->db->get('reporter');
	}
	
	public function tampil_isi(){
		$query = $this->db->query("	SELECT * FROM isi,reporter,kategori
									WHERE isi.id_reporter = reporter.id_reporter
									AND isi.id_kategori = kategori.id_kategori");

		return $query->result();

	}
	public function tampil_isi_reporter($id){
		$query = $this->db->query("	SELECT * FROM isi,reporter,kategori
									WHERE isi.id_reporter = reporter.id_reporter
									AND isi.id_kategori = kategori.id_kategori
									AND isi.id_reporter = '".$id."' ");

		return $query->result();

	}
	public function tampil_katalog($id){
		$query = $this->db->query("	SELECT * FROM katalog WHERE where id_katalog = '$id'");

		return $query->result();
	}
	public function tampil_brand($id){
		$query = $this->db->query("	SELECT * FROM brand WHERE where id_brand = '$id'");

		return $query->result();

	}
	public function tampil_packets($id){
		$query = $this->db->query("	SELECT * FROM packets WHERE where id_packets = '$id'");

		return $query->result();

	}
	
	public function read_more($id){
		$this->db->where('id_blog', $id);
		return $this->db->get('blog')->result();
	}

		
	

	public function tampil_tiket(){
		$this->db->select('
			tiket.id_tiket,
			tiket.id_status_tiket,
			tiket.id_wisata,
			tiket.kode_unik,
			wisata.nama as nama_wisata,
			wisata.alamat,
			wisata.harga,
			status_tiket.nama as status_tiket');
		$this->db->join('wisata', 'tiket.id_wisata = wisata.id_wisata', 'inner');;
		$this->db->join('status_tiket', 'tiket.id_status_tiket = status_tiket.id_status_tiket', 'left');
		$this->db->order_by('id_tiket', 'DESC');
		$query = $this->db->get('tiket');
		return $query->result();
	}
	public function tampil_wisata_no_id($id){
		$query =$this->db->query("SELECT nama, id_wisata FROM wisata WHERE id_wisata !=	 '".$id."' ORDER BY id_wisata ASC");
		return $query->result();
	}

	public function tampil_notifikasi($id){
		$this->db->select('
			pemesanan.id_pemesanan,
			pemesanan.id_user,
			pemesanan.id_wisata,
			pemesanan.jumlah,
			pemesanan.total_harga,
			pemesanan.tanggal,

			
			
			wisata.id_wisata,
			wisata.nama as nama_wisata,
			wisata.alamat,
			wisata.harga');
		$this->db->where('pemesanan.id_user', $id);
		$this->db->where('status', 'false');
		$this->db->join('wisata', 'wisata.id_wisata = pemesanan.id_wisata', 'inner');
		$query = $this->db->get('pemesanan');
		return $query->result();
	}
	
	public function tambah_id($tabel,$data){
			$this->db->insert($tabel,$data);
			$insert_id = $this->db->insert_id();
			return $insert_id;
	}
	public function tampil_pemesanan_true($tabel,$primary_key){
		$this->db->from($tabel);
		$this->db->where('status', 'false');
		$this->db->order_by($primary_key, 'DESC');
		$query = $this->db->get(); 
		return $query->result();
	}
	public function validUsername($username)
	{
		$this->db->select('*');
		$this->db->from('user');
		$this->db->where('username', $username);

		$query = $this->db->get();
		if($query->num_rows()>=1)
		{
			return $query->result();
		}else{
			return false;
		}

	}

}

/* End of file M_berita.php */
/* Location: ./application/models/M_berita.php */