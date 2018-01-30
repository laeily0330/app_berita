<?php
require APPPATH . '/libraries/REST_Controller.php';
class Latest extends REST_Controller {

	function __construct($config = 'rest') {
        parent::__construct($config);
    }
 

	function index_get() {
       $id_isi = $this->get('id_isi');
        if ($id_isi == '') {
            $isi = $this->db->query(" SELECT * FROM isi,reporter,kategori 
            							WHERE isi.id_kategori = kategori.id_kategori
                                    	AND isi.id_reporter = reporter.id_reporter
                                    	AND tanggal ORDER by tanggal DESC LIMIT 10")->result();
        } else {
            $this->db->where('id_isi', $id_isi);
            $isi = $this->db->query(" SELECT * FROM isi,reporter,kategori 
            							WHERE isi.id_kategori = kategori.id_kategori
                                    	AND isi.id_reporter = reporter.id_reporter
                                    	AND isi.id_isi = '".$id_isi."'
                                    	AND tanggal ORDER by tanggal DESC LIMIT 10")->result();
        }
        $this->response($isi, 200);
    }

}

/* End of file Latest.php */
/* Location: ./application/controllers/Latest.php */
?>