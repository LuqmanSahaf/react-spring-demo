package io.github.luqmansahaf.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import io.github.luqmansahaf.demo.database.Connector;
import io.github.luqmansahaf.demo.entity.Country;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryRepositoryCustomImpl implements CountryRepositoryCustom {

    @Autowired
    Connector connector;

    @Override
    public Single<Country> findByName(String name) {
        return Single.create(emitter -> {
            Country country = null;
            var conn = connector.getConnection();
            Statement stmt;
            try {
                stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM country WHERE name = '" + name + "'");
                if (rs.next()) {
                    country = new Country();
                    country.setName(rs.getString("name"));
                    country.setMultiplier(rs.getFloat("multiplier"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                emitter.onError(e);
            }
            emitter.onSuccess(country);
        });
    }

    @Override
    public Single<List<Country>> findAll() {
        return Single.create(emitter -> {
            List<Country> countries = new ArrayList<>();
            var conn = connector.getConnection();
            Statement stmt;
            try {
                stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM country");
                while (rs.next()) {
                    var country = new Country();
                    country.setName(rs.getString("name"));
                    country.setMultiplier(rs.getFloat("multiplier"));
                    countries.add(country);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                emitter.onError(e);
            }
            emitter.onSuccess(countries);
        });
    }
}
