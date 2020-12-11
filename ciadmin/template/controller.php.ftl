<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class ${controllerFileName} extends BaseController
{

    public function __construct()
    {
        parent::__construct();
        $this->load->model('${controllerModel}', '${controllerModelAlias}');
    }

    public function index()
    {
        $this->template->show($this, 'content');
    }

    public function form()
    {
        $this->template->show($this, 'form');
    }

    public function create()
    {
        $data = param_input();
        response($this->${controllerModelAlias}->create($data));
    }

    public function update()
    {
        $data = param_input();
        response($this->${controllerModelAlias}->update($data));
    }

    public function delete()
    {
        $data = param_input();
        response($this->${controllerModelAlias}->delete($data));
    }

    public function load()
    {
        $data = param_input();
        responseJSON($this->${controllerModelAlias}->load($data));
    }

}
