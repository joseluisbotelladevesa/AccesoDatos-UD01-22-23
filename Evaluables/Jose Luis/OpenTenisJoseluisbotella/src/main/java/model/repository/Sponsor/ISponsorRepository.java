package model.repository.Sponsor;

import model.entity.Sponsor;
import model.entity.Tenista;
import model.repository.ICrudRepository;

import java.util.List;
import java.util.UUID;

public interface ISponsorRepository extends ICrudRepository <Sponsor, Integer>{

    List<Sponsor> GetSponsorMoreRich();
}
