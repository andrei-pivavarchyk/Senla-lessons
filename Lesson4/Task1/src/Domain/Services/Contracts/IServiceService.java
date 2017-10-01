package Domain.Services.Contracts;

import Domain.Entities.Service;

public interface IServiceService {

    void addService(Service service);

    void removeService(int serviceId);
}
