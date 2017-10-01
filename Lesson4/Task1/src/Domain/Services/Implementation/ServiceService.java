package Domain.Services.Implementation;

import Domain.Contracts.IServiceRepository;
import Domain.Entities.Service;
import Domain.Services.Contracts.IServiceService;

public class ServiceService implements IServiceService {
    private IServiceRepository serviceRepository;

    public ServiceService(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void addService(Service service) {
        serviceRepository.Create(service);
    }

    @Override
    public void removeService(int serviceId) {
        serviceRepository.Delete(serviceId);
    }
}