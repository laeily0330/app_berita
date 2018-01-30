<?php
 
require APPPATH . '/libraries/REST_Controller.php';
 
class User extends REST_Controller {
 
    function __construct($config = 'rest') {
        parent::__construct($config);
    }
 
    // show data user
    function index_get() {
        $id_user = $this->get('id_user');
        if ($id_user == '') {
            $user = $this->db->get('user')->result();
        } else {
            $this->db->where('id_user', $id_user);
            $user = $this->db->get('user')->result();
        }
        $this->response($user, 200);
    }
 
    // insert new data to user
    function index_post() {
        $data = array(
                    // 'id_user'            => $this->post('id_user'),
                    'nama'         => $this->post('nama'),
                    'alamat'         => $this->post('alamat'),
                    'tanggal_lahir'         => $this->post('tanggal_lahir'),
                    'email'         => $this->post('email'),
                    'password'               => $this->post('password'));
        $insert = $this->db->insert('user', $data);
        if ($insert) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // update data user
    function index_put() {
        $id_user = $this->put('id_user');
        $data = array(
                    // 'id_user'            => $this->put('id_user'),
                    'nama'         => $this->put('nama'),
                    'alamat'         => $this->put('alamat'),
                    'tanggal_lahir'         => $this->put('tanggal_lahir'),
                    'email'         => $this->put('email'),
                    'password'               => $this->put('password'));
        $this->db->where('id_user', $id_user);
        $update = $this->db->update('user', $data);
        if ($update) {
            $this->response($data, 200);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
    // delete user
    function index_delete() {
        $id_user = $this->delete('id_user');
        $this->db->where('id_user', $id_user);
        $delete = $this->db->delete('user');
        if ($delete) {
            $this->response(array('status' => 'success'), 201);
        } else {
            $this->response(array('status' => 'fail', 502));
        }
    }
 
}