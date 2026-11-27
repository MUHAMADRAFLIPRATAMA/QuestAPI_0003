package com.example.pertemuan12.modeldata

import android.R.attr.id
import kotlinx.serialization.Serializable
import com.example.pertemuan12.uicontroller.viewmodel.DetailsSiswa

data class UIStateSiswa(
    val detailSiswa: DetailsSiswa = DetailsSiswa(),
    val isEntryValid: Boolean = false)
@Serializable
data class DataSiswa(
    val id : Int = 0,
    val nama : String ="",
    val alamat : String = "",
    val telpon : String = "",
)
fun DetailsSiswa.toDataSiswa() : DataSiswa = DataSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun DataSiswa.toUiStateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

fun DataSiswa.toDetailSiswa(): DetailsSiswa = DetailsSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)