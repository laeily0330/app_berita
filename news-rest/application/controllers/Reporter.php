<?php
 
require APPPATH . '/libraries/REST_Controller.php';
 
class Reporter extends REST_Controller {
 
    function __construct($config = 'rest') {
        parent::__construct($config);
    }
 
    // show data reporter
    function index_get() {
        $id_reporter = $this->get('id_reporter');
        if ($id_reporter == '') {
            $reporter = $this->db->get('reporter')->result();
        } else {
            $this->db->where('id_reporter', $id_reporter);
            $reporter = $this->db->get('reporter')->result();
        }
        $this->response($reporter, 200);
    }
 
    // insert new data to reporter
    function index_post() {
        $data = array(
                    // 'id_reporter'            => $this->post('id_reporter'),
                    'nama_reporter'         => $this->post('nama_reporter'),
                    'alamat'         => $this->post('alamat'),
                    'tanggal_lahir'         => $this->post('tanggal_lahir'),
                    'username'         => $this->post('username'),
                    'password'               => $this->post('password'));
        $insert = $this->db->insert('reporter', $data);
        if ($insert) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // update data reporter
    function index_put() {
        $id_reporter = $this->put('id_reporter');
        $data = array(
                    // 'id_reporter'            => $this->put('id_reporter'),
                    'nama_reporter'         => $this->put('nama_reporter'),
                    'alamat'         => $this->put('alamat'),
                    'tanggal_lahir'         => $this->put('tanggal_lahir'),
                    'username'         => $this->put('username'),
                    'password'               => $this->put('password'));
        $this->db->where('id_reporter', $id_reporter);
        $update = $this->db->update('reporter', $data);
        if ($update) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // delete reporter
    function index_delete() {
        $id_reporter = $this->delete('id_reporter');
        $this->db->where('id_reporter', $id_reporter);
        $delete = $this->db->delete('reporter');
        if ($delete) {
            $this->response(array('status' => 'success'), 201);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
}