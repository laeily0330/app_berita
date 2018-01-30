<?php
 
require APPPATH . '/libraries/REST_Controller.php';
 
class History extends REST_Controller {
 
    function __construct($config = 'rest') {
        parent::__construct($config);
    }
 
    // show data history
    function index_get() {
        $id_history = $this->get('id_history');
        if ($id_history == '') {
            $history = $this->db->query(" SELECT * FROM history,user,isi
                                    WHERE history.id_user = user.id_user
                                    AND history.id_isi = isi.id_isi")->result();
        } else {
            $this->db->where('id_history', $id_history);
            $history = $this->db->query(" SELECT * FROM history, user,isi
                                    WHERE history.id_user = user.id_user
                                    AND history.id_isi = isi.id_isi
                                    AND history.id_history = '".$id_history."'")->result();
        }
        $this->response($history, 200);
    }
 
    // insert new data to history
    function index_post() {
        $data = array(
                    // 'id_history'            => $this->post('id_history'),
                    'id_user'         => $this->post('id_user'),
                    'id_isi'         => $this->post('id_isi'),
                    'tanggal'         => $this->post('tanggal'));
        $insert = $this->db->insert('history', $data);
        if ($insert) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // update data history
    function index_put() {
        $id_history = $this->put('id_history');
        $data = array(
                    // 'id_history'            => $this->put('id_history'),
                    'id_user'         => $this->put('id_user'),
                    'id_isi'         => $this->put('id_isi'),
                    'tanggal'         => $this->put('tanggal'));
        $this->db->where('id_history', $id_history);
        $update = $this->db->update('history', $data);
        if ($update) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // delete history
    function index_delete() {
        $id_history = $this->delete('id_history');
        $this->db->where('id_history', $id_history);
        $delete = $this->db->delete('history');
        if ($delete) {
            $this->response(array('status' => 'success'), 201);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
}