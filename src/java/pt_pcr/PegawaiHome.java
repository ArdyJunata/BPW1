package pt_pcr;

import Pertemuan11.AksesJdbcOdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PegawaiHome {

    public boolean create(Pegawai pegawai) {
        AksesJdbcOdbc akses = new AksesJdbcOdbc();

        try {

            String insert = "insert into pegawai values("
                    + "'" + pegawai.getNip() + "',"
                    + "'" + pegawai.getNamaPegawai() + "',"
                    + "'" + pegawai.getAlamat() + "',"
                    + "'" + pegawai.getJabatan() + "'"
                    + ")";
            akses.connect();
            akses.executeUpdate(insert);
            akses.disconnect();

            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PegawaiHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static Pegawai getDataPegawaiByNip(String nip) {
        AksesJdbcOdbc akses = new AksesJdbcOdbc();
        Pegawai pegawai = null;
        ResultSet rs = null;
        String sql = "select * from pegawai where nip = '" + nip + "'";
        try {
            akses.connect();
            rs = akses.executeQuery(sql);
            if (rs.next()) {
                pegawai = new Pegawai();
                pegawai.setNip(rs.getString("nip"));
                pegawai.setNamaPegawai(rs.getString("nama_pegawai"));
                pegawai.setAlamat(rs.getString("alamat"));
                pegawai.setJabatan(rs.getString("jabatan"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                akses.disconnect();
                return pegawai;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static ArrayList<Pegawai> selectAll() {
        AksesJdbcOdbc akses = new AksesJdbcOdbc();
        ArrayList<Pegawai> list = new ArrayList<>();

        try {
            String query = "SELECT * FROM pegawai";
            akses.connect();

            ResultSet rs = akses.executeQuery(query);

            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setNip(rs.getString(1));
                pegawai.setNamaPegawai(rs.getString(2));
                pegawai.setAlamat(rs.getString(3));
                pegawai.setJabatan(rs.getString(4));
                list.add(pegawai);
            }

            akses.disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PegawaiHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean store(Pegawai pegawai) {
        AksesJdbcOdbc akses = new AksesJdbcOdbc();
        boolean sukses = false;
        try {
            String query = "update pegawai set nama_pegawai = '" + pegawai.getNamaPegawai() + "', alamat='" + pegawai.getAlamat() + "', jabatan='"
                    + pegawai.getJabatan() + "' where nip = '"
                    + pegawai.getNip()+ "'";
            akses.connect();

            int baris = akses.executeUpdate(query);
            if (baris > 0) {
                sukses = true;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                akses.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sukses;
    }

    public boolean delete(String nip) {
        AksesJdbcOdbc akses = new AksesJdbcOdbc();
        boolean sukses = false;
        try {
            String insert = "delete from pegawai where nip = '" + nip + "'";
            akses.connect();
            int baris = akses.executeUpdate(insert);
            if (baris > 0) {
                sukses = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                akses.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sukses;
    }
}
