package taxislibres.jeffrey.maestre.services;

import taxislibres.jeffrey.maestre.models.Bill;

import java.util.List;

public interface IBillService {
    public Bill save(Bill bill);
    public Bill update(Bill bill);
    public void delete(Long id);
    public List<Bill> findAll();
    public Bill findById(Long id);
}
