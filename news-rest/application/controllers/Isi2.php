<?php
 
require APPPATH . '/libraries/REST_Controller.php';
 
class Isi2 extends REST_Controller {
 
    function __construct($config = 'rest') {
        parent::__construct($config);
    }
 
    // show data isi
    function index_get() {
       $id_kategori = $this->get('id_kategori');
        if ($id_kategori == '') {
            $isi = $this->db->query(" SELECT * FROM isi,reporter,kategori
                                    WHERE isi.id_kategori = kategori.id_kategori
                                    AND isi.id_reporter = reporter.id_reporter")->result();
        } else {
            $this->db->where('id_kategori', $id_kategori);
            $isi = $this->db->query(" SELECT * FROM isi,reporter,kategori
                                    WHERE isi.id_kategori = kategori.id_kategori
                                    AND isi.id_reporter = reporter.id_reporter
                                    AND isi.id_kategori = '".$id_kategori."'")->result();
        }
        $this->response($isi, 200);
    }

    function index_put() {
        $id_isi = $this->put('id_isi');
        $data = array('likes'=> $this->put('likes'));
        $this->db->where('id_isi', $id_isi);
        $update = $this->db->update('isi', $data);
        if ($update) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
}