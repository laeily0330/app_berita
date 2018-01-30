<?php
 
require APPPATH . '/libraries/REST_Controller.php';
 
class Like extends REST_Controller {
 
    function __construct($config = 'rest') {
        parent::__construct($config);
    }

    function index_get() {
        $isi = $this->get('id_isi');
        // $status_req = $this->get('status_req');
        if ($id_isi == '') {
            $isi = $this->db->get('isi')->result();
        } else {
            $this->db->where('id_isi', $id_isi);
            $isi = $this->db->get('isi')->result();
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
?>