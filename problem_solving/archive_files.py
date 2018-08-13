'''
	 Question: Given a path to a directory, archive files older
	 than a month, and which can be run on 1st of every month
	 using cron job.
	 Input: directory_path days(optional)
'''
import os

class ArchiveFile(object):
	def __init__(self, directory_path, time_in_days):
		self.directory_path = directory_path
		self.time_in_days = time_in_days

	def get_directory(self):
		return self.directory_path

	def get_time(self):
		return self.time_in_days

	def check_for_valid_directory(self, directory_path):
		pass

	def check_for_valid_time(self, time_in_days):
		pass

	def get_creation_time(self, file_name):
		pass

	def move_to_archives(self):
		pass

	def get_list_of_files_recursively(self, directory_path):
		pass

if __name__ == '__main__':
	directory_path = raw_input("Enter the directory to archive: ")
	time_in_days = raw_input("Enter the time(in days) threshold more than which files to be archived: ")
	archiveControl = ArchiveFile(directory_path, time_in_days)
	
