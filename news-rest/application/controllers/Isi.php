<?php
 
require APPPATH . '/libraries/REST_Controller.php';
 
class Isi extends REST_Controller {
 
    function __construct($config = 'rest') {
        parent::__construct($config);
    }
 
    // show data isi
    function index_get() {
       $id_isi = $this->get('id_isi');
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
                                    AND isi.id_isi = '".$id_isi."'")->result();
        }
        $this->response($isi, 200);
    }
 
    // insert new data to isi
    function index_post() {
        $data = array(
                    // 'id_isi'            => $this->post('id_isi'),
                    'id_user'         => $this->post('id_user'),
                    'id_repoter'         => $this->post('id_repoter'),
                    'id_kategori'   => $this->post('id_kategori'),
                    'judul'         => $this->post('judul'),
                    'isi'         => $this->post('isi'),
                    'tanggal'               => $this->post('tanggal'));
        $insert = $this->db->insert('isi', $data);
        if ($insert) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // update data isi
    function index_put() {
        $id_isi = $this->put('id_isi');
        $data = array(
                    // 'id_isi'            => $this->put('id_isi'),
                    'id_user'         => $this->put('id_user'),
                    'id_repoter'         => $this->put('id_repoter'),
                    'id_kategori'   => $this->put('id_kategori'),
                    'judul'         => $this->put('judul'),
                    'isi'         => $this->put('isi'),
                    'tanggal'               => $this->put('tanggal'));
        $this->db->where('id_isi', $id_isi);
        $update = $this->db->update('isi', $data);
        if ($update) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // delete isi
    function index_delete() {
        $id_isi = $this->delete('id_isi');
        $this->db->where('id_isi', $id_isi);
        $delete = $this->db->delete('isi');
        if ($delete) {
            $this->response(array('status' => 'success'), 201);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
}