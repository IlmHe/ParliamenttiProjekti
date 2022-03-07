package fi.ilmarheinonen.parliamenttiprojekti

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters


class TestWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        uploadUserData()
        return Result.success()
    }

    private fun uploadUserData() {


    }
}