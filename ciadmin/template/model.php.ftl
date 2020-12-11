<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class ${modelFileName} extends CI_Model
{

    public function create($data)
    {
        $id = IDGenerator::getInstance()->nextID('${table}');
        if (!empty($id)) {
            $data['${pk}'] = $id;
        }
        return $this->db->insert('${table}', $data);
    }

    public function update($data)
    {
        $this->db->where('${pk}', $data['${pk}']);
        return $this->db->update('${table}', $data);
    }

    public function delete($data)
    {
        $this->db->where('${pk}', $data['${pk}']);
        return $this->db->delete('${table}');
    }

    public function load($data)
    {
        $field = "a.* ";
        $table = '${table} a';
        return easy_pagging($data, $field, $table);
    }

}
