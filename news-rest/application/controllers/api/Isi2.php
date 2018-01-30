<?php
 
require APPPATH . '/libraries/REST_Controller.php';
 
class Isi2 extends REST_Controller {
 
    function __construct($config = 'rest') {
        parent::__construct($config);
    }
 
    // show data isi
    function index_get() {
       $id_kategori = $this->get('id_kategori');
        if ($id_isi == '') {
            $isi = $this->db->query(" SELECT * FROM isi,user,reporter,kategori
                                    WHERE isi.id_user = user.id_user
                                    AND isi.id_kategori = kategori.id_kategori
                                    AND isi.id_reporter = reporter.id_reporter")->result();
        } else {
            $this->db->where('id_isi', $id_isi);
            $isi = $this->db->query(" SELECT * FROM isi, user,reporter,kategori
                                    WHERE isi.id_user = user.id_user
                                    AND isi.id_kategori = user.id_kategori
                                    AND isi.id_reporter = reporter.id_reporter
                                    AND isi.id_kategori = '".$id_kategori."'")->result();
        }
        $this->response($isi, 200);
    }
}