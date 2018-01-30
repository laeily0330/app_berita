<?php
 
require APPPATH . '/libraries/REST_Controller.php';
 
class Komentar extends REST_Controller {
 
    function __construct($config = 'rest') {
        parent::__construct($config);
    }
 
    // show data komentar
    function index_get() {
        $id_isi = $this->get('id_isi');
        if ($id_isi == '') {
            $komentar = $this->db->query(" SELECT * FROM komentar,user,isi
                                    WHERE komentar.id_user = user.id_user
                                    AND komentar.id_isi = isi.id_isi")->result();
        } else {
            $this->db->where('id_isi', $id_isi);
            $komentar = $this->db->query(" SELECT * FROM komentar, user,isi
                                    WHERE komentar.id_user = user.id_user
                                    AND komentar.id_isi = isi.id_isi
                                    AND komentar.id_isi = '".$id_isi."'")->result();
        }
        $this->response($komentar, 200);
    }
 
    // insert new data to komentar
    function index_post() {
        $data = array(
                    // 'id_komentar'            => $this->post('id_komentar'),
                    'id_user'         => $this->post('id_user'),
                    'id_isi'         => $this->post('id_isi'),
                    'komentar'         => $this->post('komentar'),
                    'tanggal'         => $this->post('tanggal'));
        $insert = $this->db->insert('komentar', $data);
        if ($insert) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // update data komentar
    function index_put() {
        $id_komentar = $this->put('id_komentar');
        $data = array(
                    // 'id_komentar'            => $this->put('id_komentar'),
                    'id_user'         => $this->put('id_user'),
                    'id_isi'         => $this->put('id_isi'),
                    'komentar'         => $this->put('komentar'),
                    'tanggal'         => $this->put('tanggal'));
        $this->db->where('id_komentar', $id_komentar);
        $update = $this->db->update('komentar', $data);
        if ($update) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // delete komentar
    function index_delete() {
        $id_komentar = $this->delete('id_komentar');
        $this->db->where('id_komentar', $id_komentar);
        $delete = $this->db->delete('komentar');
        if ($delete) {
            $this->response(array('status' => 'success'), 201);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
}